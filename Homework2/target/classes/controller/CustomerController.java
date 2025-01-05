package deim.urv.cat.homework2.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import deim.urv.cat.homework2.model.AlertMessage;
import deim.urv.cat.homework2.model.Customer;
import deim.urv.cat.homework2.model.CustomerDTO;
import deim.urv.cat.homework2.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.UriRef;
import jakarta.mvc.binding.BindingResult;
import jakarta.mvc.binding.ParamError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.util.List;

@Controller
@Path("Customer")
public class CustomerController {
    
    @Inject BindingResult bindingResult;
    @Inject CustomerService service;
    @Inject Models models;
    @Inject Logger log;
    @Inject HttpServletRequest request;
    
    @GET
    public String showAll() {
        List<CustomerDTO> customers = service.findAll();
        models.put("customers",customers); // Mitjançant el service guardem la informació per carregar la vista correctament
        return "customers.jsp"; // Retornem la vista on se mostraran tots el llistat de customers registrats a la BD
    }
    @GET
    @Path("name/{name}")
    public String showName(@PathParam("name") String name){
        List<CustomerDTO> customers = service.findAll();
        customers = customers.stream()
                        .filter(s -> s.getUsername().equals(name))
                        .toList();
        if(customers.size() == 1){
            models.put("customer", service.findId(customers.get(0).getId()));
            return "customer.jsp";
        } 
        else return "Error404.jsp";
    }
    
    @GET
    @Path("/{id}")
    public String showID(@PathParam("id") Long id) {
        Customer c = service.findId(id);
        if(c != null){
            models.put("customer", c);
            return "customer.jsp";
        }else return "Error404.jps";
    }
    
    @GET
    @Path("Profile")
    public String showProfile(){
        HttpSession session = request.getSession(false);
        if(session.getAttribute("username") == null){
             return "redirect:/LogIn/-3"; //No pot accedir al seu perfil si encara no ha iniciat sessio
        }
        Customer c = service.findName((String)session.getAttribute("username"));
        if(c != null){
            models.put("customer", c);
            return "profile.jsp";
        }
        return "Error404.jsp";
    }
    
    @GET
    @Path("EditProfile")
    public String editProfile(){
        HttpSession session = request.getSession(false);
        if(session.getAttribute("username") == null){
            return "redirect:/LogIn/-3"; //Si no ha iniciat sera redirigit al seu perfil una vegada hagui fet lo login
        }else{
            return "customerform.jsp";
        }  
    }
    
    @POST
    @Path("EditProfile")
    public String putCustomer(@Valid @BeanParam CustomerForm customer) {
        if (service.putCustomer(customer)){
            if (bindingResult.isFailed()) {  
                AlertMessage alert = AlertMessage.danger("Format de dades incorrecte!");
                bindingResult.getAllErrors()
                        .stream()
                        .forEach((ParamError t) -> {
                            alert.addError(t.getParamName(), "", t.getMessage());
                        });
                log.log(Level.WARNING, "Data binding for customerForm failed.");
                models.put("errors", alert);
                return "customerform.jsp";
            }
            AlertMessage alert2 = AlertMessage.success("S'han actualitzat correctament les dades");
            HttpSession session = request.getSession(false);
            if(customer.getUsername() != null) {
                session.setAttribute("username", customer.getUsername());
            }
            if(customer.getPassword() != null){
                session.setAttribute("password", customer.getPassword());
            }
            models.put("ok", alert2);
            return "customerform.jsp";
        }else{
            AlertMessage alert1 = AlertMessage.danger("Estas intentant modificar dades que no son teves!");
            models.put("errors", alert1);
            return "customerform.jsp";
        }  
    }

        
}
