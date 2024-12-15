package deim.urv.cat.homework2.controller;

import deim.urv.cat.homework2.service.ArticleService;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.UriRef;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Controller
@Path("Article")
public class ArticleController {
    
    @Inject ArticleService service;
    @Inject Models models;
    
    @GET
    public String showAll() {
        models.put("articles",service.findAll(null));
        return "articles.jsp"; // Injects CRSF token
    }
    
    @GET
    @Path("/{id}")
    public String miMetodo(@PathParam("id") Long id) {
        models.put("article",service.findId(id));
        return "article.jsp";
    }
    
    @GET
    @Path("/filter")
    @UriRef("/filter")
    public String filter(@Valid @BeanParam FilterForm filter) {
        models.put("articles",service.findAll(filter));
        return "articles.jsp"; // Injects CRSF token
    }
    
}