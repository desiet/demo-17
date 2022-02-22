package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;
import static java.time.Month.JULY;

@Configuration
public class StudentConfig {


    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {

        return args -> {


            CollageStudent mariam = new CollageStudent(
                    "Mariam",
                    "mariam.jemal@gmail.com",
                    LocalDate.of(2000, JANUARY, 5)


            );
            CollageStudent alex = new CollageStudent(
                    "alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, JANUARY, 5));


           CollageStudent efu = new CollageStudent(
                    "efu",
                   "eful@gmail.com",
                    LocalDate.of(2010, JANUARY, 5));


            CollageStudent des = new CollageStudent("des","des@gmail.com", LocalDate.of(2002,JULY,6) );
            repository.saveAll(
                    List.of(mariam, alex,des,efu)
            );
        };


    }

}