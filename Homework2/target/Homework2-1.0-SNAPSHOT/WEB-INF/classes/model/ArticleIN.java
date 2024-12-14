package deim.urv.cat.homework2.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Iulian Sebastian Oprea
 */
public class ArticleIN implements Serializable {
    
    private String titol;
    private boolean privacitat;
    private String resum;
    private String text;
    private String imatge;
    private List<Topic> topics = new ArrayList<>();
    private String autor;
    
    public ArticleIN() {
    }

    public boolean isPrivacitat() {return privacitat;}

    public void setPrivacitat(boolean privacitat) {this.privacitat = privacitat; }

    public String getResum() {return resum;}

    public void setResum(String resum) {this.resum = resum;}

    public String getText() {return text;}

    public void setText(String text) {this.text = text;}

    public String getImatge() {return imatge;}

    public void setImatge(String imatge) { this.imatge = imatge;}
    
    public String getTitol() { return titol; }
    public void setTitol(String titol) { this.titol = titol; }

    public List<Topic> getTopics() { return topics; }
    public void setTopics(List<Topic> topics) { this.topics = topics; }

    public String getAutor() {return autor;}

    public void setAutor(String autor) {this.autor = autor;}
    
}


