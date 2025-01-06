package model.entities;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Iulian Sebastian Oprea
 */
@XmlRootElement(name="articlegq")
public class ArticleGQ {
    
    private String titol;
    private String resum;
    private int visualitzacions;
    private String data;
    private String imatge;
    private String autor;
    private boolean privacitat;
    private Long id;
    private String imatgeAutor;
    
    public ArticleGQ(Article article){
        titol = article.getTitol();
        resum = article.getResum();
        visualitzacions = article.getVisualitzacions();
        data = article.getData().toString();
        imatge = article.getImatge();
        autor = article.getAutor().getUsername();
        privacitat = article.isPrivacitat();
        id = article.getId();
        imatgeAutor = article.getAutor().getProfilePhoto();
    }  
    
    public ArticleGQ(){
        
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getResum() {
        return resum;
    }

    public void setResum(String resum) {
        this.resum = resum;
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

    public boolean isPrivacitat() {
        return privacitat;
    }

    public void setPrivacitat(boolean privacitat) {
        this.privacitat = privacitat;
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
        
}
