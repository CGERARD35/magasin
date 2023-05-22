package com.magasin.magasin.mapping;

import com.magasin.magasin.api.dto.ArticleDto;
import com.magasin.magasin.model.Article;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ArticleMapper {

    public ArticleDto toDTO(Article article) {
        ArticleDto articleDTO = new ArticleDto();
        articleDTO.setId(article.getId());
        articleDTO.setDesignation(article.getDesignation());
        articleDTO.setQuantite(article.getQuantite());
        articleDTO.setPrix(article.getPrix());
        return articleDTO;
    }

    public Article toEntity(ArticleDto articleDTO) {
        Article article = new Article();
        article.setId(articleDTO.getId());
        article.setDesignation(articleDTO.getDesignation());
        article.setQuantite(articleDTO.getQuantite());
        article.setPrix(articleDTO.getPrix());
        return article;
    }
}
