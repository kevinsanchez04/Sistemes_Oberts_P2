package deim.urv.cat.homework2.controller;

import java.util.List;

import deim.urv.cat.homework2.model.Topic;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.mvc.binding.MvcBinding;
import jakarta.ws.rs.QueryParam;

@Named("filterForm")
@RequestScoped
public class FilterForm {
    
    private static final long serialVersionUID = 1L;

    @QueryParam("topics")
    @MvcBinding
    private List<Topic> topics;
    
    // JSR 303 validation
    @QueryParam("author")
    @MvcBinding
    private String author;

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
