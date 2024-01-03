package com.example.demo.features.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddArticleTagDto {
    private String name;
    private Long count;
}
