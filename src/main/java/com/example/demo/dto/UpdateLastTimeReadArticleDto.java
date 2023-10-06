package com.example.demo.dto;

import com.example.demo.constant.ContentType;
import com.example.demo.constant.Repetition;
import com.example.demo.constant.Status;
import com.example.demo.entity.Article;
import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Data
public class UpdateLastTimeReadArticleDto implements IUpdateArticleDto {
    private LocalDate lastTimeRead;

    @Override
    public void updateArticle(Article article){
        if (lastTimeRead != null && !Objects.equals(lastTimeRead, article.getLastTimeRead())) {
            article.setLastTimeRead(lastTimeRead);
        }
    }
}
