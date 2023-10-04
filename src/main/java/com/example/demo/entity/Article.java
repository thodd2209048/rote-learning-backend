package com.example.demo.entity;

import com.example.demo.constant.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Article extends BaseEntity{
    private String title;
    private String url;
    private List<String> tags;
    private String subject;
    private Status status;
    private LocalDate lastTimeRead;

    public Article(String title,
                   String url,
                   List<String> tags,
                   String subject,
                   Status status) {
        this.title = title;
        this.url = url;
        this.tags = tags;
        this.subject = subject;
        this.status = status;
    }
}
