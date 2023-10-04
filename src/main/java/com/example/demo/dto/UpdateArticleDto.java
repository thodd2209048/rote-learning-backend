package com.example.demo.dto;

import com.example.demo.constant.Status;
import com.example.demo.entity.Article;
import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Data
public class UpdateArticleDto {
    private String title;
    private String url;
    private List<String> tags;
    private String subject;
    private Status status;
    private LocalDate lastTimeRead;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public void updateArticle(Article article){
        if (title != null && !title.isEmpty() && !Objects.equals(title, article.getTitle())) {
            article.setTitle(title);
        }
        if (url != null && !url.isEmpty() && !Objects.equals(url, article.getUrl())) {
            article.setUrl(url);
        }
        if (tags != null && !tags.isEmpty() && !Objects.equals(tags, article.getTags())) {
            article.setTags(tags);
        }
        if (subject != null && !subject.isEmpty() && !Objects.equals(subject, article.getSubject())) {
            article.setSubject(subject);
        }
        if (createdAt != null && !Objects.equals(createdAt, article.getCreatedAt())) {
            article.setCreatedAt(createdAt);
        }
        if (updatedAt != null && !Objects.equals(updatedAt, article.getUpdatedAt())) {
            article.setUpdatedAt(updatedAt);
        }
        if (status != null && !Objects.equals(status, article.getStatus())) {
            article.setStatus(status);
        }
        if (lastTimeRead != null && !Objects.equals(lastTimeRead, article.getLastTimeRead())) {
            article.setLastTimeRead(lastTimeRead);
        }
    }
}
