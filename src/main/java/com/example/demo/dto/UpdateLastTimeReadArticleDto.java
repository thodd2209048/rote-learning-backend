package com.example.demo.dto;

import com.example.demo.constant.ContentType;
import com.example.demo.constant.Repetition;
import com.example.demo.constant.Status;
import com.example.demo.entity.Article;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Data
public class UpdateLastTimeReadArticleDto implements IUpdateArticleDto {

    @Override
    public void updateArticle(Article article){
            article.setLastTimeRead(LocalDate.now());
    }
}
