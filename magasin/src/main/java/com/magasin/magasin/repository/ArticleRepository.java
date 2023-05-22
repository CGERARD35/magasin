package com.magasin.magasin.repository;

import com.magasin.magasin.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer>{
}
