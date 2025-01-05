package model.entities;

import authn.Credentials;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlElement;
import java.time.LocalDate;
import java.util.List;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 *
 * @author Kevin Sánchez Ramírez
 */
@Entity
@XmlRootElement
public class Customer implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name="CUSTOMER_GEN", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_GEN")
    private Long id;
    
    @OneToOne(cascade = CascadeType.ALL) //Actualitzacions en cascada de les credencials
    @JoinColumn(name="credentials")
    @NotNull
    Credentials credentials;
   
    //private String username;
    
    @OneToMany(mappedBy = "autor")
    private List<Article> articles;
    
    @Transient //No el guardem a la BD, no ens fa falta tindre aquesta informació ja que s'actualitza dinamicament a l'aplicació
    private Links links = new Links();
    
    @NotNull
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
    
    @XmlTransient
    @JsonbTransient
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
    
    @JsonbTransient
    @XmlTransient
    public boolean isAuthor(){return !articles.isEmpty();}
    
    @XmlElement
    public String getTipusUsuari(){
        return isAuthor() ? "Autor" : "Lector";
    }
    @Override
    public String toString(){
        return "/customer/"+id;
    }
    
    @XmlTransient
    @JsonbTransient
    public String getPassword(){
        return credentials.getPassword();
    }
    
    public void setPassword(String novaContrasenya){
        credentials.setPassword(novaContrasenya);
    }
    public Customer copia() {
        Customer c = new Customer();
        c.setId(id);
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
