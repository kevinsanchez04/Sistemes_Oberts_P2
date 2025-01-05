package deim.urv.cat.homework2.model;

import java.time.LocalDate;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 *
 * @author Kevin Sánchez Ramírez
 */

public class Customer {
    
    private Long id;

    Credentials credentials;
   
    private List<Article> articles;
    
    private Links links = new Links();
    
    private LocalDate dataCreacio;
    
    private String description; //Descripció del perfil
    
    private String profilePhoto;
    
    private String username; //Cadena de caràcters que ens permetra modificar l'username posteriorment
    
    
    public Customer(){
        this.articles = new LinkedList();
        this.credentials = new Credentials();
    }
    
    public Customer(String nom_usuari, String contrasenya, String descripcio, String language){
        //username = nom_usuari;
        credentials.setUsername(nom_usuari);
        username = nom_usuari;
        credentials.setPassword(contrasenya);
        this.description = descripcio;
        dataCreacio = LocalDate.now();
        articles = new LinkedList();
    }
    
    public void addArticle(Article at){
        at.setAutor(this);
        articles.add(at);
        
    }
    

    public List<Article> getArticles() {
        return articles;
    }
    public void setArticles(List<Article> nousArticles){
        articles = nousArticles;
    }
    
    public void setCredentials(Credentials c){
        credentials = c;
        username = credentials.getUsername();
    }

    public Credentials getCredentials() {
        return credentials;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalDate getDataCreacio() {
        return dataCreacio;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public void setDataCreacio(LocalDate dataCreacio) {
        this.dataCreacio = dataCreacio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
    
    public void removeArticle(Article a){
        if(isAuthor()){
            if(articles.get(articles.size()-1).equals(a)){
                if(articles.size() > 1){
                links.setArticle(articles.get(articles.size()-2).toString()); //Fiquem el penultim ja que ara serà l'ultim
                }else{
                    links.setArticle(null); //No te cap article
                }
            }
            articles.remove(a);
        }
    }
    
    public String getUsername(){
        username = credentials.getUsername();
        return username;
    }
    
    public void setUsername(String newUsername){
        credentials.setUsername(newUsername);
        username = newUsername;
    }
    public Links getLinks(){
        if(isAuthor()){
            links.setArticle(articles.get(articles.size()-1).toString()); //Agafem el link de l'ultim article afegit
            return links;
        }else{
            return null; //Si és null no se serialitza
        }
    }
    
    public boolean isAuthor(){return !articles.isEmpty();}
    
    public String getTipusUsuari(){
        return isAuthor() ? "Autor" : "Lector";
    }
    @Override
    public String toString(){
        return "/customer/"+id;
    }

    public String getPassword(){
        return credentials.getPassword();
    }
    
    public void setPassword(String novaContrasenya){
        credentials.setPassword(novaContrasenya);
    }
    public Customer copia() {
        Customer c = new Customer();
        Credentials cds = new Credentials();
        cds.setUsername(credentials.getUsername());
        cds.setId(credentials.getId());
        cds.setPassword(cds.getPassword());
        c.setCredentials(cds);
        c.setDataCreacio(getDataCreacio());
        c.setDescription(description);
        c.setProfilePhoto(profilePhoto);
        c.setArticles(articles.stream()
                        .map(a -> a.copia())
                        .collect(Collectors.toList()));
        return c;
    }
    
}
