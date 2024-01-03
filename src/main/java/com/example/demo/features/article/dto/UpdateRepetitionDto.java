package com.example.demo.features.article.dto;

import com.example.demo.features.article.constant.Repetition;
import com.example.demo.features.article.Article;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
public class UpdateRepetitionDto implements IUpdateArticleDto {
    @NotNull
    private Repetition repetition;

    @Override
    public void updateArticle(Article article){
        if (!Objects.equals(repetition, article.getRepetition())) {
            article.setRepetition(repetition);
            article.setLastTimeRead(LocalDate.now());
        }
    }
}
