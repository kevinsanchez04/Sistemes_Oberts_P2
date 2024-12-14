/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import deim.urv.cat.homework2.model.ArticleDTO;
import deim.urv.cat.homework2.model.ArticleGQ;
import deim.urv.cat.homework2.model.Topic;

public class ArticleServiceImpl implements ArticleService {
    
    @Override
    public List<ArticleGQ> findAll(){
        
        List<ArticleGQ> lista = new LinkedList<>();
        
        // Artículo 1
        ArticleGQ article1 = new ArticleGQ();
        article1.setTitol("Título del artículo 4");
        article1.setResum("Resum del article 4");
        article1.setVisualitzacions(4500);
        article1.setPrivacitat(true);
        article1.setData("2024-11-14");
        article1.setImatge("https://www.caracteristicass.de/wp-content/uploads/2023/02/imagenes-artisticas.jpg");
        article1.setAutor("Autor4");
        lista.add(article1);
        // Artículo 2
        ArticleGQ article2 = new ArticleGQ();
        article2.setTitol("Título del artículo 5");
        article2.setResum("Resum del article 5");
        article2.setPrivacitat(false);
        article2.setVisualitzacions(4400);
        article2.setData("2024-11-15");
        article2.setImatge("https://www.caracteristicass.de/wp-content/uploads/2023/02/imagenes-artisticas.jpg");
        article2.setAutor("Autor5");
        
        for(int i = 0; i< 5;i++){
            lista.add(article2);  
        }       
        return lista;
    };
    
    @Override
    public ArticleDTO findId(Long id){
        ArticleDTO article1 = new ArticleDTO();
        article1.setTitol("Título del artículo 4");
        article1.setText("The night sky is a mesmerizing tapestry of stars, planets, and celestial wonders. "+
                    "The Milky Way, a galaxy containing our Solar System, stretches across the sky, revealing billions of stars. "+
                    "Constellations tell ancient stories, while planets like Mars and Saturn captivate with their distinct features."+ 
                    "The Moon, with its phases and influence on tides, adds to the intrigue."+ 
                    "Meteor showers bring bursts of light, making stargazing a magical experience.");
        article1.setVisualitzacions(4500);
        //article1.setPrivacitat(true);
        article1.setData("2024-11-14");
        article1.setImatge("https://www.caracteristicass.de/wp-content/uploads/2023/02/imagenes-artisticas.jpg");
        article1.setAutor("Autor4");
        List<Topic> topic = Arrays.asList(Topic.CSS,Topic.JavaScript);
        article1.setTopics(topic);
        return article1;
    }
    
}
