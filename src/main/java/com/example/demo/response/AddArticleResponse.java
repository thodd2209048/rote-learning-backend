package com.example.demo.response;

import com.example.demo.constant.ContentType;
import com.example.demo.constant.Repetition;
import com.example.demo.constant.Status;
import com.example.demo.entity.Article;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AddArticleResponse {
    private Long id;
    private String title;
    private String url;
    private List<String> tags;
    private String subject;
    private String series;
    private ContentType type;
    private Status status;
    private LocalDate lastTimeRead;
    private Repetition repetition;
    private LocalDate nextTimeRead;

    public AddArticleResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.url = article.getUrl();
        this.tags = article.getTags();
        this.subject = article.getSubject();
        this.series = article.getSeries();
        this.type = article.getType();
        this.status = article.getStatus();
        this.lastTimeRead = article.getLastTimeRead();
        this.repetition = article.getRepetition();
        this.nextTimeRead = article.getNextTimeRead();
    }
}
