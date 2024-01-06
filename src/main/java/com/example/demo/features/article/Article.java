package com.example.demo.features.article;

import com.example.demo.entity.BaseEntity;
import com.example.demo.features.article.constant.ContentType;
import com.example.demo.features.article.constant.Repetition;
import com.example.demo.features.article.constant.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
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
    @ElementCollection
    @CollectionTable(name = "article-tag", joinColumns = @JoinColumn(name =
            "id"))
    @Column(name = "tags-of-article")
    private List<String> tags;
    private String subject;
    private String series;
    @Enumerated(EnumType.STRING)
    private ContentType type;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate lastTimeRead;
    private Integer nextPeriod;
    @Transient
    private LocalDate nextTimeRead;

    public LocalDate getNextTimeRead() {
        if ( nextPeriod == null || nextPeriod == 0) return null;
        return lastTimeRead.plusDays(nextPeriod);
    }


}
