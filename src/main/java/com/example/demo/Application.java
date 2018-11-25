package com.example.demo;

import com.example.demo.domain.Visits;
import com.example.demo.repository.VisitsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(VisitsRepository visitsRepository) throws Exception {
        return (args) -> {
            IntStream.rangeClosed(1, 100).forEach(index ->
                    visitsRepository.save(Visits.builder()
                            .id(1L)
                            .url("http://www.vingle.net")
                            .visitedDate(LocalDateTime.of(2018, 3, 2, 1, 0 ,0))
                            .build())
            );
            IntStream.rangeClosed(1, 200).forEach(index ->
                    visitsRepository.save(Visits.builder()
                            .id(1L)
                            .url("http://www.vingle.net")
                            .visitedDate(LocalDateTime.of(2018, 3, 2, 2, 0 ,0))
                            .build())
            );
        };
    }
}
