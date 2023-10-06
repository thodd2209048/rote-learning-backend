package com.example.demo.entity;

import com.example.demo.constant.ContentType;
import com.example.demo.constant.Repetition;
import com.example.demo.constant.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Article extends BaseEntity{
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

    public Article(String title,
                   String url,
                   List<String> tags,
                   String subject,
                   String series,
                   ContentType type,
                   Status status) {
        this.title = title;
        this.url = url;
        this.tags = tags;
        this.series = series;
        this.type = type;
        this.subject = subject;
        this.status = status;
    }

    public LocalDate getNextTimeRead(){
        return lastTimeRead.plusDays(repetition.getStep());
    }
}
