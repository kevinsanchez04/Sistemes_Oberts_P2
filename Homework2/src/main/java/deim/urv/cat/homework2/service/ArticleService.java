package deim.urv.cat.homework2.service;

import java.util.List;

import deim.urv.cat.homework2.model.ArticleDTO;
import deim.urv.cat.homework2.model.ArticleGQ;

public interface ArticleService {
    List<ArticleGQ> findAll();
    ArticleDTO findId(Long id);
}
