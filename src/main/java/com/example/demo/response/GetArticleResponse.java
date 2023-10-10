package com.example.demo.response;

import com.example.demo.constant.ContentType;
import com.example.demo.constant.Repetition;
import com.example.demo.constant.Status;
import com.example.demo.entity.Article;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class GetArticleResponse {
    private Long id;
    private String title;
    private String url;
    private List<String> tags;
    private String subject;
    private String series;
    private ContentType type;
    private Status status;
    private Repetition repetition;
    private LocalDate lastTimeRead;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private LocalDate nextTimeRead;


    public GetArticleResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.url = article.getUrl();
        this.tags = article.getTags();
        this.subject = article.getSubject();
        this.series = article.getSeries();
        this.type = article.getType();
        this.status = article.getStatus();
        this.repetition = article.getRepetition();
        this.lastTimeRead = article.getLastTimeRead();
        this.createdAt = article.getCreatedAt();
        this.updatedAt = article.getUpdatedAt();
        this.nextTimeRead = article.getNextTimeRead();
    }

    public Integer getOverdueDays() {
        return Period.between(LocalDate.now(),nextTimeRead).getDays();
    }
}
