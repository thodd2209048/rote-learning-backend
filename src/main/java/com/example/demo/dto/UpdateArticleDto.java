package com.example.demo.dto;

import com.example.demo.constant.ContentType;
import com.example.demo.constant.Repetition;
import com.example.demo.constant.Status;
import com.example.demo.entity.Article;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Data
public class UpdateArticleDto implements IUpdateArticleDto {
    private String url;
    private String title;
    private List<String> tags;
    private String subject;
    private String series;
    private ContentType type;
    private Status status;
    private LocalDate lastTimeRead;
    private Repetition repetition;

    @Override
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
        if (series != null && !series.isEmpty() && !Objects.equals(series, article.getSeries())) {
            article.setSeries(series);
        }
        if (type != null && !Objects.equals(type, article.getType())) {
            article.setType(type);
        }
        if (status != null && !Objects.equals(status, article.getStatus())) {
            article.setStatus(status);
        }
        if (lastTimeRead != null && !Objects.equals(lastTimeRead, article.getLastTimeRead())) {
            article.setLastTimeRead(lastTimeRead);
        }
        if (repetition != null && !Objects.equals(status, article.getStatus())) {
            article.setStatus(status);
        }
    }
}
