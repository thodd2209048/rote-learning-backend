package com.example.demo.features.article;

import com.example.demo.features.article.constant.ContentType;
import com.example.demo.features.article.constant.Repetition;
import com.example.demo.features.article.constant.Status;
import com.example.demo.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@ToString
@SuperBuilder
public class Article extends BaseEntity {
    private String url;
    private String title;
    private List<String> tags;
    private String subject;
    private String series;
    private ContentType type;
    private Status status;
    private LocalDate lastTimeRead;
    private Repetition repetition;
    @Transient
    private LocalDate nextTimeRead;

    public LocalDate getNextTimeRead() {
        if (repetition == null ||
                lastTimeRead == null ||
                repetition.getStepString().equals("completed")) return null;
        return lastTimeRead.plusDays(repetition.getNextPeriod());
    }
}
