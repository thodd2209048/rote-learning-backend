package com.example.demo.features.article;

import com.example.demo.features.article.dto.AddArticleDto;
import com.example.demo.features.article.dto.UpdateArticleDto;
import com.example.demo.features.article.dto.UpdateRepetitionDto;
import com.example.demo.features.article.response.AddArticleResponse;
import com.example.demo.features.article.response.GetArticleResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/articles")
public class ArticleController {
    private final ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<GetArticleResponse> getArticles() {
        return articleService.listArticleResponse();
    }

    @GetMapping(path = "/{articleId}")
    public GetArticleResponse getArticleById(@PathVariable Long articleId) {return articleService.getArticleResponseById(articleId);}

    @PostMapping
    public AddArticleResponse addArticle(@RequestBody AddArticleDto addArticleDto) {
        System.out.println(addArticleDto);
        return articleService.addArticle(addArticleDto);
    }

    @PutMapping("/{articleId}")
    public void updateArticle(@PathVariable Long articleId, @Valid @RequestBody UpdateArticleDto updateArticleDto) {
        articleService.updateArticle(articleId, updateArticleDto);
    }

    @DeleteMapping(path = {"articleId"})
    public void deleteArticle(@PathVariable("articleId") Long articleId) {
        articleService.deleteArticle(articleId);
    }


//    @GetMapping("/extract")
//    public void extract(){
//        articleService.extract();
//    }
}
