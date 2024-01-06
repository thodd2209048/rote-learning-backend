package com.example.demo.features.article;

import com.example.demo.features.article.dto.AddArticleDto;
import com.example.demo.features.article.dto.UpdateArticleDto;
import com.example.demo.features.article.response.AddArticleResponse;
import com.example.demo.features.article.response.GetArticleResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public Page<GetArticleResponse> getArticles(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String tag
    ) {
        return articleService.listArticleResponse(pageable, date, search, tag);
    }

    @GetMapping(path = "/{articleId}")
    public GetArticleResponse getArticleById(@PathVariable Long articleId) {
        return articleService.getArticleResponseById(articleId);
    }

    @PostMapping
    public AddArticleResponse addArticle(@RequestBody AddArticleDto addArticleDto) {
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
//        articleService.moveData();
//    }
}
