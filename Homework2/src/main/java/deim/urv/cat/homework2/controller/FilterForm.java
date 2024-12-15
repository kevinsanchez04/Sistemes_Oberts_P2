package deim.urv.cat.homework2.controller;

import deim.urv.cat.homework2.model.Topic;
import jakarta.inject.Named;
import jakarta.mvc.binding.MvcBinding;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.QueryParam;
import java.util.List;

@Named("filterForm")
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
