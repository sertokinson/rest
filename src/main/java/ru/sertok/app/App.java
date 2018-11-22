package ru.sertok.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "ru.sertok")
@EnableJpaRepositories(basePackages = "ru.sertok.repositories")
@EntityScan(basePackages = "ru.sertok.models")
@ImportResource({"classpath*:context.xml"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
