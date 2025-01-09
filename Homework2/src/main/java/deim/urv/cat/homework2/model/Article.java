package deim.urv.cat.homework2.model;

import java.time.LocalDate;
import java.util.List;

public class Article {
   
    private Long id;

    private boolean privacitat;
    
   
    private String titol;
    
    private String resum;
    
    private String text;
    
    private int visualitzacions = 0;
    private LocalDate data;
    
    private String imatge;
    
    private List<Topic> topics;
    
    private Customer autor;

    public Article(Long id, Customer autor, String message, boolean privacitat, String titol, String resum, String text, LocalDate data, String imatge) {
        this.id = id;
        this.privacitat = privacitat;
        this.titol = titol;
        this.resum = resum;
        this.text = text;
        this.data = data;
        this.imatge = imatge;
        this.autor = autor;
        autor.addArticle(this);
    }
    
    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPrivacitat() {
        return privacitat;
    }

    public void setPrivacitat(boolean privacitat) {
        this.privacitat = privacitat;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getVisualitzacions() {
        return visualitzacions;
    }

    public void setVisualitzacions(int visualitzacions) {
        this.visualitzacions = visualitzacions;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public Customer getAutor() {
        return autor;
    }

    public void setAutor(Customer autor) {
        this.autor = autor;
    }

    public void incVis(){
        visualitzacions++;
    }
    
    public Article copia() {
        Article a = new Article();
        a.setAutor(null);
        a.setData(data);
        a.setId(id);
        a.setImatge(imatge);
        a.setPrivacitat(privacitat);
        a.setResum(resum);
        a.setText(text);
        a.setTitol(titol);
        a.setTopics(topics);
        a.setVisualitzacions(visualitzacions);
        return a;
    }
    
    @Override
    public String toString(){
        return "/article/"+id;
    }
    
}
