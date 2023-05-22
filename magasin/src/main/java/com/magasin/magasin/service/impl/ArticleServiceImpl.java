package com.magasin.magasin.service.impl;

import com.magasin.magasin.model.Article;
import com.magasin.magasin.repository.ArticleRepository;
import com.magasin.magasin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article getById(Integer id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Article not found: " + id));
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Integer id, Article updatedArticle) {
        Article articleExistant = getById(id);
        articleExistant.setDesignation(updatedArticle.getDesignation());
        articleExistant.setQuantite(updatedArticle.getQuantite());
        articleExistant.setPrix(updatedArticle.getPrix());
        return articleRepository.save(articleExistant);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleRepository.deleteById(id);
    }
}
