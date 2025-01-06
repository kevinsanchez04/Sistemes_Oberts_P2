/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import authn.Credentials;
import authn.Secured;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.StatusType;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import model.entities.Article;
import model.entities.Customer;
import model.entities.CustomerDTO;

/**
 *
 * @author Kevin
 */
@Stateless
@Path("customer")
public class CustomerFacadeRest extends AbstractFacade<Customer>{
    
    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;
    
    public CustomerFacadeRest() {
        super(Customer.class);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findAllCustomers() {
        List<Customer> customers = super.findAll();
        List<CustomerDTO> customersDTO = customers.stream()
                .map(x -> new CustomerDTO(x))
                .collect(Collectors.toList());
        GenericEntity<List<CustomerDTO>> entity = new GenericEntity<List<CustomerDTO>>(customersDTO) {}; 
        return Response.ok(entity).build();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findCustomer(@PathParam("id") Long id) {
        Customer customer = super.find(id);
        if(customer != null){
            Customer auxiliar = customer.copia(); //Lleva recursivitat dels articles amb el camp autor
            return Response.ok(auxiliar).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("Customer amb id:"+id+" no es troba la Bases de Dades").build();
        }
        
    }
    
    
    @PUT
    @Secured
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response putCustomer(Customer c, @PathParam("id") Long id, @HeaderParam("Authorization") String auto){
             // Decodificar el encabezado Base64
            String credentials = auto.substring("Basic ".length()).trim();
            String decodedCredentials = new String(Base64.getDecoder().decode(credentials));

            // Separar usuario y contraseña
            String[] userDetails = decodedCredentials.split(":");
            if (userDetails.length != 2) {
                return Response.status(Response.Status.UNAUTHORIZED)
                               .entity("Invalid credentials format").build();
            }

            String username = userDetails[0];
            String password = userDetails[1];
            Credentials cds = new Credentials();
            cds.setPassword(password);
            cds.setUsername(username);
            Customer c2 = super.find(id);
            if (c2 != null) {
                if(comprovarCredencials(c2, cds)){
                    if(c.getDescription() != null) c2.setDescription(c.getDescription());
                    if(c.getProfilePhoto() != null) c2.setProfilePhoto(c.getProfilePhoto());
                    if(c.getUsername() != null)  c2.setUsername(c.getUsername());
                    if(c.getPassword() != null) c2.setPassword(c.getPassword());
                    em.merge(c2);
                    return Response.ok(c2.copia()).build();
                }else{
                    return Response.status(Response.Status.UNAUTHORIZED).entity("Les dades que estas intentant modificar NO son teves").build();
                }
            }else{
                return Response.status(Response.Status.NOT_FOUND).entity("El customer amb id:"+id+" no es troba a la Base de Dades").build();
            }   
            
    }
    
    @GET
    @Path("name/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findCustomerName(@PathParam("name") String name){
        String query = "Select c FROM Customer c WHERE c.credentials.username = :userName";
        try{
            Customer c = em.createQuery(query,Customer.class)
                    .setParameter("userName",name)
                    .getSingleResult();
            return Response.ok(c.copia()).build();
        }catch(Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @GET
    @Path("/validate")
    @Secured
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response validate() {
        return Response.ok().build();
    }
    
    /*Funció auxiliar per comprovar si les credencials correponen a l'usuari que volem modificar*/
    public boolean comprovarCredencials(Customer c, Credentials cs){
        return((c.getCredentials().getUsername().compareTo(cs.getUsername())) == 0 && 
                (c.getCredentials().getPassword().compareTo(cs.getPassword())) == 0);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
