package deim.urv.cat.homework2.controller;

import deim.urv.cat.homework2.model.AlertMessage;
import deim.urv.cat.homework2.model.ArticleDTO;
import deim.urv.cat.homework2.service.ArticleService;
import deim.urv.cat.homework2.UnauthorizedExp;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.UriRef;
import jakarta.mvc.binding.BindingResult;
import jakarta.mvc.binding.ParamError;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@Path("Article")
public class ArticleController {
    
    @Inject BindingResult bindingResult;
    @Inject ArticleService service;
    @Inject Models models;
    @Inject Logger log;
    
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
                models.put("message", "You Have To Be Logged");
                models.put("articles",service.findAll(null));
                return "articles.jsp";
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
        return "articleform.jsp"; // Injects CRSF token
    }
    
    @POST
    @UriRef("/insert")
    public String filter(@Valid @BeanParam ArticleForm article) throws UnauthorizedExp {
        if (bindingResult.isFailed()) {
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
