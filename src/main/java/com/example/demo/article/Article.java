package com.example.demo.article;

import com.example.demo.constant.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Article {
    @Id
    @SequenceGenerator(
            name = "article_id_sequence",
            sequenceName = "article_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "article_id_sequence"
    )
    private Long id;
    private String title;
    private String url;
    private List<String> tags;
    private String subject;
    private ZonedDateTime createdAt;
    private ZonedDateTime updateAt;
    private Status status;
    private ZonedDateTime lastTimeRead;

    public Article(String title,
                   String url,
                   List<String> tags,
                   String subject,
                   ZonedDateTime createdAt,
                   ZonedDateTime updateAt,
                   Status status,
                   ZonedDateTime lastTimeRead) {
        this.title = title;
        this.url = url;
        this.tags = tags;
        this.subject = subject;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.status = status;
        this.lastTimeRead = lastTimeRead;
    }
}
