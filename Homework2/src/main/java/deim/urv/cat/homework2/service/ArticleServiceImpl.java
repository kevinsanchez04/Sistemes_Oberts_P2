package deim.urv.cat.homework2.service;

import java.util.List;

import deim.urv.cat.homework2.UnauthorizedExp;
import deim.urv.cat.homework2.controller.ArticleForm;
import deim.urv.cat.homework2.controller.FilterForm;
import deim.urv.cat.homework2.model.ArticleDTO;
import deim.urv.cat.homework2.model.ArticleGQ;
import deim.urv.cat.homework2.model.Topic;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.client.Entity;
import static jakarta.ws.rs.client.Entity.text;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Base64;

public class ArticleServiceImpl implements ArticleService {
    
    @Inject HttpServletRequest request;
    
    private final WebTarget webTarget;
    private final jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/Homework1/rest/api/v1";
    
    public ArticleServiceImpl() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("article");
    }
    
    @Override
    public List<ArticleGQ> findAll(FilterForm filter){
        WebTarget target = webTarget;
        if (filter != null){
            for(Topic topic : filter.getTopics()){
                target = target.queryParam("topic", topic.name());
            }
            if(!filter.getAuthor().equals("NULL")){
                target = target.queryParam("author", filter.getAuthor());
            }
        }
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        if (response.getStatus() == 200) {
            return response.readEntity(new GenericType<List<ArticleGQ>>() {});
        }
        return null;
    };
    
    @Override
    public ArticleDTO findId(Long id) throws NullPointerException{
        Response response = webTarget
                .path(id.toString())
                .request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, code())
                .get();
        if (response.getStatus() == 200) {
            return response.readEntity(ArticleDTO.class);
        }else if(response.getStatus() == 400){
            throw new NullPointerException();
        }
        return null;
    }
    
    @Override
    public boolean newArticle(ArticleForm art) throws UnauthorizedExp{
        Response response = webTarget.request(MediaType.APPLICATION_JSON)
               .header(HttpHeaders.AUTHORIZATION, code())
               .post(Entity.entity(art, MediaType.APPLICATION_JSON), 
                    Response.class);
        return response.getStatus() == 201;
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
