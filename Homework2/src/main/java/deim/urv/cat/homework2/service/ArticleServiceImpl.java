package deim.urv.cat.homework2.service;

import java.util.Arrays;
import java.util.List;

import deim.urv.cat.homework2.model.ArticleDTO;
import deim.urv.cat.homework2.model.ArticleGQ;
import deim.urv.cat.homework2.model.Topic;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import deim.urv.cat.homework2.controller.FilterForm;
import deim.urv.cat.homework2.controller.UserForm;
import jakarta.ws.rs.client.Entity;
import java.util.stream.Collectors;

public class ArticleServiceImpl implements ArticleService {
    
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
    public ArticleDTO findId(Long id){
         Response response = webTarget.path(id.toString())
                .request(MediaType.APPLICATION_JSON)
                .get();
        if (response.getStatus() == 200) {
            return response.readEntity(ArticleDTO.class);
        }
        return null;
    }
    
}
