package com.example.demo.controller;

import com.example.demo.dto.AddArticleDto;
import com.example.demo.dto.UpdateArticleDto;
import com.example.demo.entity.Article;
import com.example.demo.response.AddArticleResponse;
import com.example.demo.response.GetArticleResponse;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/article")
public class ArticleController {
    private final ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public AddArticleResponse addArticle(@RequestBody AddArticleDto article) {
        return articleService.addArticle(article);
    }

    @GetMapping
    public List<GetArticleResponse> getArticles() {
        return articleService.getArticles();
    }

    @PutMapping("/{articleId}")
    public void updateArticle(@PathVariable Long articleId, @RequestBody UpdateArticleDto newArticle) {
        articleService.updateArticle(articleId, newArticle);
    }

    @DeleteMapping(path = {"articleId"})
    public void deleteArticle(@PathVariable("articleId") Long articleId) {
        articleService.deleteArticle(articleId);
    }

    @GetMapping(path = "subjects")
    public List<String> getAllSubject() {
        return articleService.getAllSubject();
    }
}