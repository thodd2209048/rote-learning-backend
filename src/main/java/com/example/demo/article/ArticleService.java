package com.example.demo.article;

import com.example.demo.constant.Status;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository repository) {
        this.articleRepository = repository;
    }

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public Article addArticle(Article article) {
        Optional<Article> articleOptionalUrl = articleRepository.findArticleByUrl(article.getUrl());
        if (articleOptionalUrl.isPresent()) {
            throw new IllegalStateException("article with url: " + article.getUrl() + " is exists");
        }

        return articleRepository.save(article);
    }

    public void deleteArticle(Long articleId) {
        boolean exists = articleRepository.existsById(articleId);
        if (!exists) {
            throw new IllegalStateException("Article with id: " + articleId + "does not exists");
        }
        articleRepository.deleteById(articleId);
    }

    public void updateArticle(Long articleId,
                              String title,
                              String url,
                              List<String> tags,
                              String subject,
                              ZonedDateTime createdAt,
                              ZonedDateTime updateAt,
                              Status status,
                              ZonedDateTime lastTimeRead) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalStateException("Article with id: " + articleId + "does not exists"));

        if (title != null && !title.isEmpty() && !Objects.equals(title, article.getTitle())) {
            article.setTitle(title);
        }
        if (url != null && !url.isEmpty() && !Objects.equals(url, article.getUrl())) {
            article.setUrl(url);
        }
        if (tags != null && !tags.isEmpty() && !Objects.equals(tags, article.getTags())) {
            article.setTags(tags);
        }
        if (subject != null && !subject.isEmpty() && !Objects.equals(subject, article.getSubject())) {
            article.setSubject(subject);
        }
        if (createdAt != null && !Objects.equals(createdAt, article.getCreatedAt())) {
            article.setCreatedAt(createdAt);
        }
        if (updateAt != null && !Objects.equals(updateAt, article.getUpdateAt())) {
            article.setUpdateAt(updateAt);
        }
        if (status != null && !Objects.equals(status, article.getStatus())) {
            article.setStatus(status);
        }
        if (lastTimeRead != null && !Objects.equals(lastTimeRead, article.getLastTimeRead())) {
            article.setLastTimeRead(lastTimeRead);
        }
    }
}
