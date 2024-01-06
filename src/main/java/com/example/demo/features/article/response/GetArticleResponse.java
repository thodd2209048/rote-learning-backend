package com.example.demo.features.article.response;

import com.example.demo.features.article.constant.ContentType;
import com.example.demo.features.article.constant.Repetition;
import com.example.demo.features.article.constant.Status;
import com.example.demo.features.article.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private LocalDate nextTimeRead;

}
