package com.vishal.springboot.jpa.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    private JdbcTemplate jdbcTemplate;

    public CourseJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static String INSERT_QUERY =
            """
                    INSERT INTO course (name, author) VALUES
                    ('Spring Boot', 'Vishal'),
                    ('Hibernate JPA', 'Ranga'),
                    ('Microservices', 'John'),
                    ('Java 8 Streams', 'Amit'),
                    ('Mockito & JUnit', 'Suresh');
                    
                    """;

    public void insert() {
        jdbcTemplate.update(INSERT_QUERY);
    }
}
