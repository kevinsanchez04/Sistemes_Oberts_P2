package deim.urv.cat.homework2.controller;

import jakarta.mvc.binding.MvcBinding;
import jakarta.ws.rs.FormParam;

public class CustomerForm {
    
    @FormParam("username")
    @MvcBinding
    private String username;
    
      @FormParam("password")
    @MvcBinding
    private String password;
    
     @FormParam("profilePhoto")
    @MvcBinding
    private String profilePhoto;
    
    @FormParam("description")
    @MvcBinding
    private String description;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
