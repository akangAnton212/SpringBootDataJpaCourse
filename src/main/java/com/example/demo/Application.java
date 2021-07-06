package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {

            for(int i = 0; i < 100; i++){
                Student s = new Student(
                    "Antons"+ i,
                    "Soeds"+ i,
                    "akangantons212@gmail.com"+ i,
                    26
                );
                studentRepository.save(s);
            }
            
        };
    }

}
