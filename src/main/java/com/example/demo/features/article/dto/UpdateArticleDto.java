package com.example.demo.features.article.dto;

import com.example.demo.features.article.constant.ContentType;
import com.example.demo.features.article.constant.Repetition;
import com.example.demo.features.article.constant.Status;
import com.example.demo.features.article.Article;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateArticleDto {
    private String url;
    private String title;
    private List<String> tags;
    private String subject;
    private String series;
    private ContentType type;
    private Status status;
    private Repetition repetition;
    private LocalDate lastTimeRead;

    public void setLastTimeRead() {
        if(this.repetition != null){
            this.lastTimeRead = LocalDate.now();
        }
    }
}
