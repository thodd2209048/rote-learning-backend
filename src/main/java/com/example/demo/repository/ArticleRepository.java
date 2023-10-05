package com.example.demo.repository;

import com.example.demo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT a FROM Article a WHERE a.url = ?1")
    Optional<Article> findArticleByUrl(String url);
    @Query("SELECT a FROM Article a WHERE a.title = ?1")
    Optional<Article> findArticleByTitle(String title);
    @Query("SELECT DISTINCT a.subject FROM Article a")
    List<String> getAllSubject();

}