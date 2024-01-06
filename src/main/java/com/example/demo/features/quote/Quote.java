package com.example.demo.features.quote;

import com.example.demo.entity.BaseEntity;
import com.example.demo.entity.SequenceIdBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "quotes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Quote extends SequenceIdBaseEntity {
    @Column(columnDefinition = "text")
    private String content;
    private String author;
}
