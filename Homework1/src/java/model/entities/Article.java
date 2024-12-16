package model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.List;

@Entity
@XmlRootElement(name="article")
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="ARTICLE_GEN", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTICLE_GEN") 
    private Long id;

    private boolean privacitat;
    
    @NotNull(message="Article has to have TITOL")
    private String titol;
    
    @NotNull(message="Article has to have RESUM")
    @Column(length=20)
    private String resum;
    
    @NotNull(message="Article has to have TEXT")
    @Column(length=500)
    private String text;
    
    private int visualitzacions = 0;
    private LocalDate data;
    
    @NotNull(message="Article has to have IMAGE")
    private String imatge;
    
    @NotNull(message="Article has to have two Topics")
    @ElementCollection(targetClass = Topic.class)
    @Enumerated(EnumType.STRING)
    private List<Topic> topics;
    
    @NotNull(message="Article has to have an Author")
    @ManyToOne
    @JoinColumn(name="autor_id")
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

    public Article(ArticleIN art){
        this.privacitat = art.isPrivacitat();
        this.titol = art.getTitol();
        this.text = art.getText();
        this.resum = art.getResum();
        this.imatge = art.getImatge();
        this.topics = art.getTopics();
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
