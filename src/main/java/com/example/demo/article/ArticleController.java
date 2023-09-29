package com.example.demo.article;

import com.example.demo.constant.Status;
import com.example.demo.tags.Tag;
import com.example.demo.tags.TagController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/article")
public class ArticleController {
    private final ArticleService articleService;
    private final TagController tagController;

    @Autowired
    public ArticleController(ArticleService articleService, TagController tagController) {
        this.articleService = articleService;
        this.tagController = tagController;
    }

    @GetMapping
    @CrossOrigin
    public List<Article> getArticles() {
        return articleService.getArticles();
    }

    @PostMapping
    public Article addArticle(@RequestBody Article article) {
        for (String tagName : article.getTags()
        ) {
            if (tagController.isTagExists(tagName)) {
                tagController.incrementOccurrenceCount(tagName);
            } else {
                tagController.addNewTag(
                        new Tag(tagName, 1L, ZonedDateTime.now(), ZonedDateTime.now())
                );
            }
        }
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
