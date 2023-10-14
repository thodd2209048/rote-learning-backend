package com.example.demo.entity;

import com.example.demo.constant.ContentType;
import com.example.demo.constant.Repetition;
import com.example.demo.constant.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
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

    public Article(String url,
                   String title,
                   List<String> tags,
                   String subject,
                   String series,
                   ContentType type,
                   Status status,
                   Repetition repetition,
                   LocalDate lastTimeRead
    ) {
        this.title = title;
        this.url = url;
        this.tags = tags;
        this.series = series;
        this.type = type;
        this.subject = subject;
        this.status = status;
        this.repetition = repetition;
        this.lastTimeRead = lastTimeRead;

    }

    public LocalDate getNextTimeRead() {
        if (repetition == null ||
                lastTimeRead == null ||
                repetition.getStepString().equals("completed")) return null;
        return lastTimeRead.plusDays(repetition.getNextPeriod());
    }

    @Override
    public String toString() {
        return "Article{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", tags=" + tags +
                ", subject='" + subject + '\'' +
                ", series='" + series + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", lastTimeRead=" + lastTimeRead +
                ", repetition=" + repetition +
                ", nextTimeRead=" + nextTimeRead +
                "} " + super.toString();
    }
}
