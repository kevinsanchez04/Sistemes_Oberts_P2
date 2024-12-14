package deim.urv.cat.homework2.controller;

import deim.urv.cat.homework2.service.ArticleService;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Controller
@Path("Article")
public class ArticleController {
    
    @Inject ArticleService service;
    @Inject Models models;
    
    @GET
    public String showForm() {
        models.put("articles",service.findAll());
        return "articles.jsp"; // Injects CRSF token
    }
    
    @GET
    @Path("/{id}")
    public String miMetodo(@PathParam("id") Long id) {
        models.put("article",service.findId(id));
        return "article.jsp";
    }
}