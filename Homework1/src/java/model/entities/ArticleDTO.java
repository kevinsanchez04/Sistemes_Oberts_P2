package model.entities;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *
 * @author Iulian Sebastian Oprea
 */
@XmlRootElement
public class ArticleDTO {
    
    private String imatge;
    private String titol;
    private String autor;
    private int visualitzacions;
    private List<Topic> topics;
    private String text;
    private String data;
    private String imatgeAutor;
    private Long id;
    
    public ArticleDTO(Article article){
        titol = article.getTitol();
        text = article.getText();
        visualitzacions = article.getVisualitzacions();
        data = article.getData().toString();
        imatge = article.getImatge();
        autor = article.getAutor().getUsername();
        topics = article.getTopics();
        imatgeAutor = article.getAutor().getProfilePhoto();
        id = article.getId();
    }  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
    public String getImatgeAutor() {
        return imatgeAutor;
    }

    public void setImatgeAutor(String imatgeAutor) {
        this.imatgeAutor = imatgeAutor;
    }
    
    public ArticleDTO(){
        
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public int getVisualitzacions() {
        return visualitzacions;
    }

    public void setVisualitzacions(int visualitzacions) {
        this.visualitzacions = visualitzacions;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
