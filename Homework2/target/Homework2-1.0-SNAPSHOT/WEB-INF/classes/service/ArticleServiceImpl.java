/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.service;

import deim.urv.cat.homework2.model.ArticleGQ;
import java.util.LinkedList;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    
    @Override
    public List<ArticleGQ> findAll(){
        
        List<ArticleGQ> lista = new LinkedList<>();
        
        // Artículo 1
        ArticleGQ article1 = new ArticleGQ();
        article1.setTitol("Título del artículo 4");
        article1.setResum("Resum del article 4");
        article1.setVisualitzacions(4500);
        article1.setData("2024-11-14");
        article1.setImatge("https://www.caracteristicass.de/wp-content/uploads/2023/02/imagenes-artisticas.jpg");
        article1.setAutor("Autor4");
        lista.add(article1);
        // Artículo 2
        ArticleGQ article2 = new ArticleGQ();
        article2.setTitol("Título del artículo 5");
        article2.setResum("Resum del article 5");
        article2.setVisualitzacions(4400);
        article2.setData("2024-11-15");
        article2.setImatge("https://www.caracteristicass.de/wp-content/uploads/2023/02/imagenes-artisticas.jpg");
        article2.setAutor("Autor5");
        lista.add(article2);
        return lista;
    };   
}
