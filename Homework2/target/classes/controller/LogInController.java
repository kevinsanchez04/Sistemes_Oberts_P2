package deim.urv.cat.homework2.controller;

import deim.urv.cat.homework2.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Controller
@Path("LogIn")
public class LogInController {
        
    @Inject Models models;
    @Inject HttpServletRequest request;
    @Inject CustomerService service;
    
    @GET
    @Path("/{id}")
    public String show(@PathParam("id") Long id){
        models.put("message", null);
        models.put("valor",id);
        return "login.jsp";
    }
    
    @GET
    @Path("/article")
    public String goToArticle(@Valid @BeanParam LogInForm log){
        if(!validar(log)){
            models.put("errorMessage", "Username or password incorrect");
            models.put("valor", log.getId());
            return "login.jsp";
        } 
        //Depenent del id rediriguim a la pagina corresponent
        if(log.getId() == 0) return "redirect:Article";
        if(log.getId() == -1) return "redirect:Article/addArticle";
        if(log.getId() == -3) return "redirect:Customer/Profile";
        if(log.getId() < -2) return "redirect:Article/Delete/"+valor(log.getId());
        return "redirect:/Article/"+log.getId();
    }
    
    private String valor(Long id){
        Long ids = Math.abs(id);
        String val = id.toString();
        return val.substring(2);
    }
    
    private boolean validar(LogInForm log){
        String username = log.getUsername();
        String password = log.getPassword();
        HttpSession session = request.getSession(true); //Creem una sessió en los camps indicats per l'usuari
        session.setAttribute("username",username); 
        session.setAttribute("password",password);
        if(!service.validate()){
            session.invalidate();
            return false;
        }
        return true;
    }
}
