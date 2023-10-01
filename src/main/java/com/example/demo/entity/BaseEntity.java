package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;


@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public BaseEntity(ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
