package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Value("${FRONT_END_URL}")
    private String frontEndUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(frontEndUrl, "http://localhost:3000")
                .allowedMethods("GET","POST","PUT", "DELETE")
//                .allowedHeaders("header1", "header2", "header3")
//                .exposedHeaders("header1", "header2")
                .allowCredentials(false).maxAge(3600);
    }
}