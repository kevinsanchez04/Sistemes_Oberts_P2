/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.model;

import java.util.List;

/**
 *
 * @author Kevin
 */
public class CustomerDTO {
    private Long id;
    private String username;
    private String profilePhoto;
    private Links links = new Links();
    
    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.username = customer.getUsername();
        this.profilePhoto = customer.getProfilePhoto();
        List<Article> articles = customer.getArticles();
        if(!articles.isEmpty())
        this.links.setArticle(articles.get(articles.size()-1).toString());
    }

    public CustomerDTO() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public boolean isAuthor() {
        return (links.getArticle() != null);
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }    

    public Links getLinks() {
        return isAuthor() ? links:null;
    }

    public void setLinks(Links link) {
        this.links = link;
    }
    public String getTipusUsuari(){
        return isAuthor() ? "Autor" : "Lector";
    }
    
}

