package com.example.demo.article;

import com.example.demo.constant.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/article")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    @CrossOrigin
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
    public void updateArticle(
            @PathVariable("articleId") Long articleId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String url,
            @RequestParam(required = false) List<String> tags,
            @RequestParam(required = false) String subject,
            @RequestParam(required = false) ZonedDateTime createdAt,
            @RequestParam(required = false) ZonedDateTime updateAt,
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) ZonedDateTime lastTimeRead
    ) {
        articleService.updateArticle(articleId, title, url, tags, subject, createdAt, updateAt, status, lastTimeRead);
    }
}
