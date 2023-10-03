package com.example.demo.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
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


    @GetMapping
    public List<Article> getArticles() {
        return articleService.getArticles();
    }

    @PostMapping
    public Article addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    @DeleteMapping(path = {"articleId"})
    public void deleteArticle(@PathVariable("articleId") Long articleId) {
        articleService.deleteArticle(articleId);
    }

    @PutMapping(path = {"articleId"})
    public void updateArticle(@PathVariable("articleId") Long articleId, @RequestBody Article newArticle
    ) {
        articleService.updateArticle(articleId, newArticle);
    }

    @GetMapping(path = "subjects")
    public List<String> getAllSubject() {
        return articleService.getAllSubject();
    }
}
