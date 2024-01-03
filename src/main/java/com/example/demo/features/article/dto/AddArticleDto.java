package com.example.demo.features.article.dto;

import com.example.demo.features.article.constant.ContentType;
import com.example.demo.features.article.constant.Repetition;
import com.example.demo.features.article.constant.Status;
import com.example.demo.features.article.Article;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddArticleDto {
    @NotBlank
    @Size(max = 200, message = "Maximum url length is 200 characters.")
    private String url;
    @NotBlank
    @Size(max = 100, message = "Maximum title length is 100 characters.")
    private String title;
    @NotBlank
    @Size(max = 100, message = "Maximum subject length is 100 characters.")
    private String subject;
    @Size(max = 100, message = "Maximum series length is 100 characters.")
    private String series;
    @NotNull
    private List<String> tags;
    @NotNull
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
