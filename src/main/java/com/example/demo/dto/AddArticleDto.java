package com.example.demo.dto;

import com.example.demo.constant.ContentType;
import com.example.demo.constant.Repetition;
import com.example.demo.constant.Status;
import com.example.demo.entity.Article;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddArticleDto {
    @NotBlank
    @Size(max = 100, message = "Maximum title length is 100 characters.")
    private String title;

    @NotBlank
    @Size(max = 200, message = "Maximum url length is 200 characters.")
    private String url;

    @NotNull
    private List<String> tags;

    @NotBlank
    @Size(max = 100, message = "Maximum subject length is 100 characters.")
    private String subject;

    @Size(max = 100, message = "Maximum series length is 100 characters.")
    private String series;

    @NotNull
    private ContentType type;

    private Status status;
    private Repetition repetition;


    public Article toArticle() {
        if (type == null) {
            type = ContentType.ARTICLE;
        }
        return new Article(url, title, tags, subject, series, type, status, repetition, LocalDate.now());
    }

}
