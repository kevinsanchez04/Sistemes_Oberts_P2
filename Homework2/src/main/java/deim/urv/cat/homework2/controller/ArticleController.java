package deim.urv.cat.homework2.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import deim.urv.cat.homework2.UnauthorizedExp;
import deim.urv.cat.homework2.model.AlertMessage;
import deim.urv.cat.homework2.model.ArticleDTO;
import deim.urv.cat.homework2.service.ArticleService;
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
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Controller
@Path("Article")
public class ArticleController {
    
    @Inject BindingResult bindingResult;
    @Inject ArticleService service;
    @Inject Models models;
    @Inject Logger log;
    @Inject HttpServletRequest request;
    
    @GET
    public String showAll() {
        models.put("articles",service.findAll(null));
        return "articles.jsp"; // Injects CRSF token
    }
    
    @GET
    @Path("/{id}")
    public String miMetodo(@PathParam("id") Long id) {
        try{
            ArticleDTO art = service.findId(id);
            if(art == null){
                return "redirect:/LogIn/"+id;
            }
            models.put("article",art);
            return "article.jsp";            
        }catch(NullPointerException e){
            models.put("message", "Bad Request");
            return "articles.jsp";
        }
    }
    
    @GET
    @Path("/filter")
    @UriRef("/filter")
    public String filter(@Valid @BeanParam FilterForm filter) {
        models.put("articles",service.findAll(filter));
        return "articles.jsp"; // Injects CRSF token
    }
    
    @GET
    @Path("/addArticle")
    @UriRef("addArticle")
    public String addArticle() {

        HttpSession session = request.getSession(false);
        if(session.getAttribute("username") == null){
            return "redirect:/LogIn/-1"; // -1 Long vol dir que es per afegir article / Decisio de disseny /
        } 

        return "articleform.jsp"; 
    }
    
    @POST
    @UriRef("/insert")
    public String filter(@Valid @BeanParam ArticleForm article) throws UnauthorizedExp {
        if (!service.newArticle(article) && bindingResult.isFailed()) {
            AlertMessage alert = AlertMessage.danger("Validation failed!");
            bindingResult.getAllErrors()
                    .stream()
                    .forEach((ParamError t) -> {
                        alert.addError(t.getParamName(), "", t.getMessage());
                    });
            log.log(Level.WARNING, "Data binding for signupFormController failed.");
            models.put("errors", alert);
            return "articleform.jsp";
        }
        models.put("articles",service.findAll(null));
        return "articles.jsp";

    }
}
