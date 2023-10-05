package com.example.demo.response;

import com.example.demo.constant.Status;
import com.example.demo.entity.Article;
import lombok.Data;

import java.util.List;

@Data
public class GetArticleResponse {
    private String title;
    private String url;
    private List<String> tags;
    private String subject;
    private Status status;

    public GetArticleResponse(Article article) {
        this.title = article.getTitle();
        this.url = article.getUrl();
        this.tags = article.getTags();
        this.subject = article.getSubject();
        this.status = article.getStatus();
    }
}
