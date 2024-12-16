/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin
 */
@XmlRootElement
public class Links implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String article = null;

    public Links() {
    }
    
    public String getArticle(){return article;}
    
    public void setArticle(String s){article = s;}
}
