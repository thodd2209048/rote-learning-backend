package com.example.demo.features.article;

import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.features.article.dto.AddArticleDto;
import com.example.demo.features.article.dto.UpdateArticleDto;
import com.example.demo.features.article.dto.UpdateRepetitionDto;
import com.example.demo.features.article.response.AddArticleResponse;
import com.example.demo.features.article.response.GetArticleResponse;
import com.example.demo.features.serie.SeriesService;
import com.example.demo.features.subject.SubjectService;
import com.example.demo.features.tag.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ArticleMapper mapper;
    private final TagService tagService;
    private final SubjectService subjectService;
    private final SeriesService seriesService;

    public ArticleService(ArticleRepository repository,
                          ArticleMapper mapper,
                          TagService tagService,
                          SubjectService subjectService,
                          SeriesService seriesService) {
        this.articleRepository = repository;
        this.mapper = mapper;
        this.tagService = tagService;
        this.subjectService = subjectService;
        this.seriesService = seriesService;
    }

    public List<GetArticleResponse> listArticleResponse() {
        return articleRepository.findAll()
                .stream()
                .map(mapper::toGetArticleResponse)
                .toList();
    }

    public GetArticleResponse getArticleResponseById(Long articleId) {
        Article article = this.getArticle(articleId);
        return mapper.toGetArticleResponse(article);
    }

    private Article getArticle(Long id){
        return articleRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Article with id " + id + " does not exists"));
    }

    public List<Article> listArticles() {
        return articleRepository.findAll();
    }

    @Transactional
    public AddArticleResponse addArticle(AddArticleDto addArticleDto) {
        System.out.println(addArticleDto);
        Optional<Article> articleOptionalUrl = articleRepository.findArticleByUrl(addArticleDto.getUrl());
        if (articleOptionalUrl.isPresent()) {
            throw new IllegalStateException("article with url: " + addArticleDto.getUrl() + " is exists");
        }

        Article newArticle = mapper.fromAddArticleResponse(addArticleDto);
        articleRepository.save(newArticle);

        List<String> tagNames = addArticleDto.getTags();
        for (String tagName : tagNames
        ) {
            tagService.tagIncrease(tagName);
        }

        String subjectName = addArticleDto.getSubject();
        subjectService.subjectCountIncrease(subjectName);

        String seriesName = addArticleDto.getSeries();
        seriesService.seriesCountIncrease(seriesName);

        AddArticleResponse addArticleResponse = mapper.toAddArticleResponse(newArticle);
        System.out.println(addArticleResponse);
        return addArticleResponse;

    }

    @Transactional
    public void deleteArticle(Long id) {
        Article article = this.getArticle(id);

        List<String> tagNames = article.getTags();
        for (String tagName : tagNames
        ) {
            tagService.tagDecrease(tagName);
        }

        String subjectName = article.getSubject();
        subjectService.subjectCountDecrease(subjectName);

        String seriesName = article.getSeries();
        seriesService.seriesCountDecrease(seriesName);

        articleRepository.deleteById(id);
    }

    public void updateArticle(Long id, UpdateArticleDto updateArticleDto) {
        Article article = this.getArticle(id);

        mapper.updateFromUpdateArticleDto(updateArticleDto, article);
    }


//    public void save(Article article) {
//        articleRepository.save(article);
//    }

//    ONLY USE FOR FIRST TIME GET INFORMATION
//    public void extract() {
//        List<Article> articles = this.listArticles();
//        Map<String, Long> tagMap = new HashMap<>();
//        for (Article article : articles
//        ) {
//            String name = article.getSeries();
////            String normalizedTag = name.toLowerCase(Locale.ROOT).replaceAll("\\p{M}", "");
//            if (name != null) {
//                tagMap.merge(name, 1L, Long::sum);
//            }
//        }
//
//        List<Series> tagList = new ArrayList<>();
//        for (Map.Entry<String, Long> entry : tagMap.entrySet()) {
//            tagList.add(new Series(entry.getKey(), entry.getValue()));
//        }
//
//        seriesService.saveAll(tagList);
//    }
}
