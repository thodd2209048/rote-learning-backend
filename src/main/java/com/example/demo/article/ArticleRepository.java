package com.example.demo.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT a FROM article a WHERE a.url = ?1")
    Optional<Article> findArticleByUrl(String url);
    @Query("SELECT a FROM article a WHERE a.title = ?1")
    Optional<Article> findArticleByTitle(String title);
}
