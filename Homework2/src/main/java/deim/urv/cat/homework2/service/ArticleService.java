package deim.urv.cat.homework2.service;

import java.util.List;

import deim.urv.cat.homework2.model.ArticleDTO;
import deim.urv.cat.homework2.model.ArticleGQ;
import deim.urv.cat.homework2.controller.FilterForm;

public interface ArticleService {
    List<ArticleGQ> findAll(FilterForm filter);
    ArticleDTO findId(Long id);
}
