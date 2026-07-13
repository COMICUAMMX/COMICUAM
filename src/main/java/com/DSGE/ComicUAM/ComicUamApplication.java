package com.dsge.comicuam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// Le indicamos explícitamente a Spring que busque en todo el proyecto
@ComponentScan(basePackages = "com.dsge.comicuam") 
@EnableJdbcRepositories(basePackages = "com.dsge.comicuam.repositorios")
public class ComicUamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComicUamApplication.class, args);
    }
}