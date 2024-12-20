package deim.urv.cat.homework2.controller;

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
    
    @GET
    @Path("/{id}")
    public String show(@PathParam("id") Long id){
        models.put("valor",id);
        return "login.jsp";
    }
    
    @GET
    @Path("/article")
    public String goToArticle(@Valid @BeanParam LogInForm log){
        validar(log);
        //Depenent del id rediriguim a la pagina corresponent
        if(log.getId() == 0) return "redirect:Article";
        if(log.getId() == -1) return "redirect:Article/addArticle";
        return "redirect:/Article/"+log.getId();
    }
    
    private boolean validar(LogInForm log){
        HttpSession session = request.getSession(true);
        session.setAttribute("username",log.getUsername());
        session.setAttribute("password",log.getPassword());
        return true;
    }
}
