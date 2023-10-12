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

    @Override
    public void updateArticle(Article article){
        System.out.println(repetition);
        if (!Objects.equals(repetition, article.getRepetition())) {
            article.setRepetition(repetition);
            article.setLastTimeRead(LocalDate.now());
        }
    }
}
