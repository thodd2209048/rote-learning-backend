package com.example.demo.tags;

import com.example.demo.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Table
@Data
public class Tag extends BaseEntity {
    private String name;
    private Long occurrenceCount;

    public Tag(String name, Long occurrenceCount, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        super(createdAt, updatedAt);
        this.name = name;
        this.occurrenceCount = occurrenceCount;
    }

    public Tag(String name, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        super(createdAt, updatedAt);
        this.name = name;
    }
}
