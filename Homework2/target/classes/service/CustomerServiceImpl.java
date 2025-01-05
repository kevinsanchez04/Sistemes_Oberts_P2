/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.service;

import deim.urv.cat.homework2.UnauthorizedExp;
import deim.urv.cat.homework2.controller.CustomerForm;
import deim.urv.cat.homework2.model.Customer;
import deim.urv.cat.homework2.model.CustomerDTO;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Base64;
import java.util.List;
import sun.print.resources.serviceui;

/**
 *
 * @author Kevin
 */
public class CustomerServiceImpl implements CustomerService{
    private final WebTarget webTarget;
    private final jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/Homework1/rest/api/v1";
    @Inject HttpServletRequest request;
    
    public CustomerServiceImpl(){
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("customer");
    }
    public CustomerServiceImpl(WebTarget webTarget, Client client) {
        this.webTarget = webTarget;
        this.client = client;
    }
    @Override
    public List<CustomerDTO> findAll() {
        Response response = webTarget
                            .request(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                            .get();
        if (response.getStatus() == 200) {
            return response.readEntity(new GenericType<List<CustomerDTO>>() {});
        }
        return null;
    }
    
    @Override
    public Customer findId(Long id) {
        Response response = webTarget
                            .path(id.toString())
                            .request(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                            .get();
        if(response.getStatus() == 200){
            return response.readEntity(Customer.class);
        }else return null;
    }

    @Override
public boolean putCustomer(CustomerForm cust) {
    System.out.println("Dades del formulari:"+cust.getUsername()+" "+cust.getPassword()+" "+cust.getProfilePhoto()+" "+cust.getDescription());
    HttpSession session = request.getSession(false);
    String username = (String) session.getAttribute("username");
    if (username == null) {
        System.err.println("Session username is null.");
        return false;
    }
    Customer c = findName(username);
    if (c == null) {
        System.err.println("Customer not found for username: " + username);
        return false;
    }
    Customer aux = new Customer();
    aux.setId(c.getId());
    aux.setPassword(cust.getPassword());
    aux.setDescription(cust.getDescription());
    aux.setProfilePhoto(cust.getProfilePhoto());
    aux.setUsername(cust.getUsername());
        System.out.println("Dades de l'usuari nou:"+aux.getDescription()+" "+aux.getUsername()+" "+aux.getPassword());
    Response response = webTarget
            .path("/"+aux.getId())
            .request(MediaType.APPLICATION_JSON)
            .header(HttpHeaders.AUTHORIZATION, code())
            .put(Entity.entity(aux, MediaType.APPLICATION_JSON));
    System.out.println("Response status: " + response.getStatus());
    if (response.getStatus() != 200) {
        System.err.println("Error updating customer: " + response.readEntity(String.class));
    }
    return (response.getStatus() == 200);
}


    @Override
    public Customer findName(String name) {
        Response response = webTarget
                            .path("name/"+name)
                            .request(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                            .get();
        if(response.getStatus() == 200){
            return response.readEntity(Customer.class);
        }else return null;
    }
    
    public String code(){
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        String unified = username+":"+password;
        String encodedText = "Basic " +Base64.getEncoder().encodeToString(unified.getBytes());
        return encodedText;
    }
    
}
