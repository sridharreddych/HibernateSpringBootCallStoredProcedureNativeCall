package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.fetchAnthologyAuthors();
            bookstoreService.fetchAnthologyAuthorsNameAndAge();
        };
    }
}
/*
 * Calling Stored Procedure That Returns A Result Set Via Native Query

Description: This application is an example of calling a MySQL stored procedure that returns a result set (entity or DTO) via a native query.

Key points:

rely on a native call as @Query(value = "{CALL FETCH_AUTHOR_BY_GENRE (:p_genre)}", nativeQuery = true)
 */
