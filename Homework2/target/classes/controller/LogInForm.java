package deim.urv.cat.homework2.controller;

import jakarta.mvc.binding.MvcBinding;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.QueryParam;

public class LogInForm {
    
    @QueryParam("username")
    @MvcBinding
    @NotBlank
    @Size(min=2, max=30, message = "Title must be between 2 and 30 characters")
    private String username;
    
    @QueryParam("password")
    @MvcBinding
    @NotBlank
    @Size(min=2, max=30, message = "Password must be between 2 and 30 characters")
    private String password;
    
    @QueryParam("id")
    @MvcBinding
    private Long id;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
