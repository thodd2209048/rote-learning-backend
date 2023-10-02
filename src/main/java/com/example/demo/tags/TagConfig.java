package com.example.demo.tags;

import com.example.demo.article.Article;
import com.example.demo.article.ArticleRepository;
import com.example.demo.constant.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class TagConfig {
    @Bean
    CommandLineRunner tagCommandLineRunner(TagRepository repository){
        return args -> {
            ZonedDateTime createdAt = ZonedDateTime.now();
            ZonedDateTime updatedAt = ZonedDateTime.now();
            Tag tagJava = new Tag("java", createdAt, updatedAt);
            Tag tagSecurity = new Tag("security", createdAt, updatedAt);
            Tag tagCwp = new Tag("cwp", createdAt, updatedAt);
            ZonedDateTime lastTimeRead = ZonedDateTime.now();

            repository.saveAll(List.of(tagJava, tagSecurity, tagCwp));
        };
    }
}
