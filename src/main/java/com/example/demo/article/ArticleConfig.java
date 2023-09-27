package com.example.demo.article;

import com.example.demo.constant.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ArticleConfig {
    @Bean
    CommandLineRunner commandLineRunner(ArticleRepository repository){
        return args -> {
            List<String> tags = new ArrayList<>();
            tags.add("Java");
            tags.add("Programming");

            ZonedDateTime createdAt = ZonedDateTime.now();
            ZonedDateTime updatedAt = ZonedDateTime.now();
            ZonedDateTime lastTimeRead = ZonedDateTime.now();

            Article article = new Article("Example Article", "https://example.com/article",
                    tags, "Programming and Java", createdAt, updatedAt,
                    Status.COMPLETED, lastTimeRead);


            repository.saveAll(List.of(article));
        };
    }
}
