package com.example.demo.features.quote.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddQuoteDto {
    @NotBlank
    private String content;
    private String author;
}
