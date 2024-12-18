package deim.urv.cat.homework2.controller;

import deim.urv.cat.homework2.model.Topic;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.mvc.binding.MvcBinding;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.FormParam;
import java.util.List;

@Named("articleForm")
@RequestScoped
public class ArticleForm {
    
    @FormParam("titol")
    @MvcBinding
    @NotBlank
    @Size(min=2, max=30, message = "Title must be between 2 and 30 characters")
    private String titol;
    
    @FormParam("text")
    @MvcBinding
    @NotBlank
    @Size(min=2, max=255, message = "Text must be between 2 and 255 characters")
    private String text;
    
    @FormParam("resum")
    @MvcBinding
    @NotBlank
    @Size(min=2, max=20, message = "Resum must be between 2 and 20 characters")
    private String resum;
    
    @FormParam("autor")
    @MvcBinding
    @NotBlank
    @Size(min=2, max=30, message = "username must be between 2 and 30 characters")
    private String autor;
    
    @FormParam("imatge")
    @MvcBinding
    @NotBlank
    @Size(max=1024, message = "Image must be between 2 and 1024 characters")
    private String imatge;
    
    @FormParam("topics")
    @MvcBinding
    private List<Topic> topics;
    
    @FormParam("privacitat")
    @MvcBinding
    private boolean privacitat;

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResum() {
        return resum;
    }

    public void setResum(String resum) {
        this.resum = resum;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public boolean isPrivacitat() {
        return privacitat;
    }

    public void setPrivacitat(boolean privacitat) {
        this.privacitat = privacitat;
    }
    
    
    
}
