package com.magasin.magasin.service;

import com.magasin.magasin.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();

    Article getById(Integer id);

    Article createArticle(Article article);

    Article updateArticle(Integer id, Article updatedArticle);

    void deleteArticle(Integer id);
}
