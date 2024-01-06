package com.example.demo.features.article.dto;

import com.example.demo.features.article.constant.ContentType;
import com.example.demo.features.article.constant.Repetition;
import com.example.demo.features.article.constant.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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
    private LocalDate lastTimeRead;
    private Repetition repetition;
    private Integer nextPeriod;


    public void setLastTimeRead() {
        this.lastTimeRead = LocalDate.now();
    }

    public LocalDate getLastTimeRead() {
        return LocalDate.now();
    }
}
