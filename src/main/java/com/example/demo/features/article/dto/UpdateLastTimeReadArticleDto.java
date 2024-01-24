package com.example.demo.features.article.dto;

import com.example.demo.features.article.constant.Repetition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLastTimeReadArticleDto {
    private Repetition repetition;
}
