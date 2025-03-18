package com.InjectingCollections;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;

//@Configuration
public class AppConfig {

   // @Bean
    public List<String> subjects() {
        return Arrays.asList("Mathematics", "Science", "History", "English");
    }
}
