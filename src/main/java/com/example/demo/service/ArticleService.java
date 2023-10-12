package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.entity.Article;
import com.example.demo.response.AddArticleResponse;
import com.example.demo.response.GetArticleResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository repository) {
        this.articleRepository = repository;
    }

    public List<GetArticleResponse> getArticles() {
        return articleRepository.findAll()
                .stream()
                .map(GetArticleResponse::new)
                .toList();
    }

    public List<GetArticleResponse> getReReadingArticles() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        return articleRepository.findAll()
                .stream()
                .filter(a -> a.getNextTimeRead()!=null && a.getNextTimeRead().isBefore(tomorrow))
                .map(GetArticleResponse::new)
                .toList();
    }

    public AddArticleResponse addArticle(AddArticleDto article) {
        try{
            Optional<Article> articleOptionalUrl = articleRepository.findArticleByUrl(article.getUrl());
            if (articleOptionalUrl.isPresent()) {
                throw new IllegalStateException("article with url: " + article.getUrl() + " is exists");
            }

            Article newArticle = article.toArticle();
            articleRepository.save(newArticle);

            return new AddArticleResponse(newArticle);
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

//    public void updateArticle(Long id, UpdateArticleDto newArticle) {
//        Article article = articleRepository.findById(id)
//                .orElseThrow(() -> new IllegalStateException("Article with id: " + id + "does not exists"));
//
//        newArticle.updateArticle(article);
//        articleRepository.save(article);
//    }
//
//    public void updateLastTimeRead(Long id, UpdateLastTimeReadArticleDto newArticle) {
//        Article article = articleRepository.findById(id)
//                .orElseThrow(() -> new IllegalStateException("Article with id: " + id + "does not exists"));
//
//        newArticle.updateArticle(article);
//        articleRepository.save(article);
//    }

//    public <T extends IUpdateArticleDto> void updateArticle(Long id, T newArticle){
//        Article article = articleRepository.findById(id)
//                .orElseThrow(() -> new IllegalStateException("Article with id: " + id + "does not exists"));
//
//        newArticle.updateArticle(article);
//        System.out.println(newArticle);
//        articleRepository.save(article);
//    }
public  void updateArticle(Long id, UpdateArticleDto newArticle){
    Article article = articleRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("Article with id: " + id + "does not exists"));

    newArticle.updateArticle(article);
    System.out.println(newArticle);
    articleRepository.save(article);
}

    public  void updateRepetitionArticle(Long id, UpdateRepetitionDto newArticle){
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Article with id: " + id + "does not exists"));

        newArticle.updateArticle(article);
        System.out.println(newArticle);
        articleRepository.save(article);
    }

    public List<String> getAllSubject() {
        return articleRepository.getAllSubject();
    }



}
