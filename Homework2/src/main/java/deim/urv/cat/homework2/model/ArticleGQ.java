package deim.urv.cat.homework2.model;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;


/**
 *
 * @author Iulian Sebastian Oprea
 */
public class ArticleGQ {
    
    private String titol;
    private String resum;
    private int visualitzacions;
    private String data;
    private String imatge;
    private String autor;
    private boolean privacitat;

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
    
    public String splitData(){
        String[] dates = data.split("-");
        return Month.of(Integer.parseInt(dates[1])).getDisplayName(TextStyle.SHORT,Locale.ENGLISH)+" "+ dates[2];
    }
    public boolean isPrivacitat() {
        return privacitat;
    }

    public void setPrivacitat(boolean privacitat) {
        this.privacitat = privacitat;
    }
}
