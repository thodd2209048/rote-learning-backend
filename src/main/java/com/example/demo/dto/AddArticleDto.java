package com.example.demo.dto;

import com.example.demo.constant.Status;
import com.example.demo.entity.Article;
import lombok.Data;

import java.util.List;

@Data
public class AddArticleDto {
    private String title;
    private String url;
    private List<String> tags;
    private String subject;
    private Status status;

    public AddArticleDto(String title, String url, List<String> tags, String subject, Status status) {
        this.title = title;
        this.url = url;
        this.tags = tags;
        this.subject = subject;
        this.status = status;
    }

    public Article toArticle(){
        return new Article(title, url, tags, subject, status);
    }
}
