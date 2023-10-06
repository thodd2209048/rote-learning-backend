package com.example.demo.dto;

import com.example.demo.constant.Repetition;
import com.example.demo.entity.Article;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
public class UpdateRepetitionDto implements IUpdateArticleDto {
    @NotNull
    private Repetition repetition;
    @NotNull
    private LocalDate lastTimeRead;

    @Override
    public void updateArticle(Article article){
        if (!Objects.equals(lastTimeRead, article.getLastTimeRead())) {
            article.setLastTimeRead(lastTimeRead);
        }
        if (!Objects.equals(repetition, article.getRepetition())) {
            article.setRepetition(repetition);
        }
    }
}
