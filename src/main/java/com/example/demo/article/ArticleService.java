package com.example.demo.article;

import com.example.demo.constant.Status;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository repository;

    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    public List<Article> getArticles() {
        return repository.findAll();
    }

    public void addArticle(Article article) {
        Optional<Article>articleOptionalUrl = repository.findArticleByUrl(article.getUrl());
        if (articleOptionalUrl.isPresent()){
            throw new IllegalStateException("article with url: "+article.getUrl()+" is exists");
        }

        repository.save(article);
    }
}
