package com.example.demo.features.quote.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteResponse {
    private Long id;
    private String content;
    private String author;
}
