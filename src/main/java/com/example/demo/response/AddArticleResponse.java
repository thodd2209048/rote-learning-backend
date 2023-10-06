package com.example.demo.response;

import com.example.demo.constant.ContentType;
import com.example.demo.constant.Status;
import com.example.demo.entity.Article;
import lombok.Data;

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

    public AddArticleResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.url = article.getUrl();
        this.tags = article.getTags();
        this.subject = article.getSubject();
        this.series = article.getSeries();
        this.type = article.getType();
        this.status = article.getStatus();
    }
}
