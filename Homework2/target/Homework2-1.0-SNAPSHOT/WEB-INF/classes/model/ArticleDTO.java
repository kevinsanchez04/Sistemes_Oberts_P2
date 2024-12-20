package deim.urv.cat.homework2.model;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Iulian Sebastian Oprea
 */
public class ArticleDTO {
    
    private String imatge;
    private String titol;
    private String autor;
    private int visualitzacions;
    private List<Topic> topics;
    private String text;
    private String data;
  
    public ArticleDTO(){
        
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
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

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String splitData(){
        String[] dates = data.split("-");
        return Month.of(Integer.parseInt(dates[1])).getDisplayName(TextStyle.SHORT,Locale.ENGLISH)+" "+ dates[2]+", "+dates[0];
    }
}
