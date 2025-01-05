/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.model;

/**
 *
 * @author Kevin
 */
public class Links {
    
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
