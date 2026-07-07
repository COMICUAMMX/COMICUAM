package com.dsge.comicuam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ComicUamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComicUamApplication.class, args);
	}

}
