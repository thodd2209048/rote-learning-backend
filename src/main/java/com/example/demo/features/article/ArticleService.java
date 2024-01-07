package com.example.demo.features.article;

import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.features.article.dto.AddArticleDto;
import com.example.demo.features.article.dto.UpdateArticleDto;
import com.example.demo.features.article.response.AddArticleResponse;
import com.example.demo.features.article.response.GetArticleResponse;
import com.example.demo.features.serie.SeriesService;
import com.example.demo.features.subject.SubjectService;
import com.example.demo.features.tag.TagService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository repository;
    private final ArticleMapper mapper;
    private final TagService tagService;
    private final SubjectService subjectService;
    private final SeriesService seriesService;

    public ArticleService(ArticleRepository repository,
                          ArticleMapper mapper,
                          TagService tagService,
                          SubjectService subjectService,
                          SeriesService seriesService) {
        this.repository = repository;
        this.mapper = mapper;
        this.tagService = tagService;
        this.subjectService = subjectService;
        this.seriesService = seriesService;
    }

    public Page<GetArticleResponse> listArticleResponse(Pageable pageable,
                                                        LocalDate date,
                                                        String search,
                                                        String tag) {
        Page<Article> articles = repository.findAllByNextTimeReadBeForeNow(pageable, date, search, tag);
        return articles
                .map(this::convertToGetArticleResponse);
    }

    public GetArticleResponse getArticleResponseById(Long articleId) {
        Article article = this.getArticle(articleId);
        return this.convertToGetArticleResponse(article);
    }

    private Article getArticle(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Article with id " + id + " does not exists"));
    }

    public List<Article> listArticles() {
        return repository.findAll();
    }

    @Transactional
    public AddArticleResponse addArticle(AddArticleDto addArticleDto) {
        Optional<Article> articleOptionalUrl = repository.findArticleByUrl(addArticleDto.getUrl());
        if (articleOptionalUrl.isPresent()) {
            throw new IllegalStateException("Article with url: " + addArticleDto.getUrl() + " is exists");
        }

        Article newArticle = this.convertFromAddArticleDto(addArticleDto);
        newArticle.setLastTimeRead(LocalDate.now());
        repository.save(newArticle);

        if(addArticleDto.getTags()!=null || !addArticleDto.getTags().isEmpty()){
            this.increaseCountTags(addArticleDto.getTags());
        }

        if (addArticleDto.getSubject() != null) {
            subjectService.increaseSubjectCount(addArticleDto.getSubject());
        }

        if (addArticleDto.getSeries() != null) {
            seriesService.increaseSeriesCount(addArticleDto.getSeries());
        }

        return mapper.toAddArticleResponse(newArticle);

    }

    @Transactional
    public void updateArticle(Long id, UpdateArticleDto updateArticleDto) {
        Article article = this.getArticle(id);

        if (updateArticleDto.getSubject() != null) {
            subjectService.increaseSubjectCount(updateArticleDto.getSubject());
            subjectService.decreaseSubjectCount(article.getSubject());
        }

        if (updateArticleDto.getSeries() != null) {
            seriesService.increaseSeriesCount(updateArticleDto.getSeries());
            seriesService.decreaseSeriesCount(article.getSeries());
        }

        if (updateArticleDto.getTags() != null) {
            this.decreaseCountTags(article.getTags());
            this.increaseCountTags(updateArticleDto.getTags());
        }

        mapper.updateFromUpdateArticleDto(updateArticleDto, article);

        article.setLastTimeRead(LocalDate.now());

        repository.save(article);
    }

    @Transactional
    public void deleteArticle(Long id) {
        Article article = this.getArticle(id);

        this.decreaseCountTags(article.getTags());

        String subjectName = article.getSubject();
        subjectService.decreaseSubjectCount(subjectName);

        String seriesName = article.getSeries();
        seriesService.decreaseSeriesCount(seriesName);

        repository.deleteById(id);
    }


    private GetArticleResponse convertToGetArticleResponse(Article article) {
        GetArticleResponse response = mapper.toGetArticleResponse(article);

        return response;
    }

    private Article convertFromAddArticleDto(AddArticleDto addArticleDto) {
        Article article = mapper.fromAddArticleDto(addArticleDto);
        return article;
    }

    private void decreaseCountTags(List<String> tagNames) {
        for (String tagName : tagNames
        ) {
            tagService.tagDecrease(tagName);
        }
    }

    private void increaseCountTags(List<String> tagNames) {
        for (String tagName : tagNames
        ) {
            tagService.tagIncrease(tagName);
        }
    }

//    public void moveData() {
//        List<Article> articles = repository.findAll();
//        for (Article a : articles
//        ) {
//            if(a.getRepetition()==null){
//                a.setNextPeriod(null);
//            } else{
//                a.setNextPeriod(a.getRepetition().getNextPeriod());
//            }
//
//            a.setType(a.getType().toUpperCase());
//            a.setStatus(a.getStatus().toUpperCase());
//            repository.save(a);
//        }
//    }
}
