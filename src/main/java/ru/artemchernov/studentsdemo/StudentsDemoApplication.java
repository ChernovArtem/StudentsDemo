package ru.artemchernov.studentsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentsDemoApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(StudentsDemoApplication.class);
        app.run(args);
    }
}
