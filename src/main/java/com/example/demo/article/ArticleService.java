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
        try{
            Optional<Article> articleOptionalUrl = articleRepository.findArticleByUrl(article.getUrl());
            if (articleOptionalUrl.isPresent()) {
                throw new IllegalStateException("article with url: " + article.getUrl() + " is exists");
            }
            if(article.getUpdateAt()== null){
                article.setUpdateAt(ZonedDateTime.now());
            }
            if(article.getCreatedAt() == null){
                article.setCreatedAt(ZonedDateTime.now());
            }
            if(article.getLastTimeRead() == null){
                article.setLastTimeRead(ZonedDateTime.now());
            }
            if(article.getStatus()==null){
                article.setStatus(Status.COMPLETED);
            }

            return articleRepository.save(article);
        } catch (IllegalStateException e){
            e.printStackTrace();
        }
        return null;
    }

    public void deleteArticle(Long articleId) {
        boolean exists = articleRepository.existsById(articleId);
        if (!exists) {
            throw new IllegalStateException("Article with id: " + articleId + "does not exists");
        }
        articleRepository.deleteById(articleId);
    }

    public void updateArticle(Long id, Article newArticle) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Article with id: " + id + "does not exists"));

        String title = newArticle.getTitle();
        String url = newArticle.getUrl();
        List<String> tags = newArticle.getTags();
        String subject = newArticle.getSubject();
        ZonedDateTime createdAt = newArticle.getCreatedAt();
        ZonedDateTime updateAt = newArticle.getUpdateAt();
        Status status = newArticle.getStatus();
        ZonedDateTime lastTimeRead = newArticle.getLastTimeRead();

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

    public List<String> getAllSubject() {
        return articleRepository.getAllSubject();
    }
}
