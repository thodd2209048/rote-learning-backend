package com.example.demo.features.article.dto;

import com.example.demo.features.article.Article;
import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Data
public class UpdateLastTimeReadArticleDto implements IUpdateArticleDto {

    @Override
    public void updateArticle(Article article){
            article.setLastTimeRead(LocalDate.now());
        article.setUpdatedAt(ZonedDateTime.now());
    }
}
