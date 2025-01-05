/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kevin
 */
@XmlRootElement
public class Links implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String article = null;
    private Long id;

    public Links() {
    }
    
    public String getArticle(){return article;}
    
    public void setArticle(String s){
        article = s;
        String[] parts = article.split("/");
            if (parts.length > 1) 
                id = Long.valueOf(parts[parts.length -1]);
    }
    @JsonbTransient
    @XmlTransient
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
