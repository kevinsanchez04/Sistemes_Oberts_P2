package deim.urv.cat.homework2.model;

public class Credentials { 
    private Long id;
    private String username;
    private String password;

    private Customer customer; //Cada usuari tindrà només unes credencials, per identificar-se

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
    
    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer c){
        customer = c;
    }
}
