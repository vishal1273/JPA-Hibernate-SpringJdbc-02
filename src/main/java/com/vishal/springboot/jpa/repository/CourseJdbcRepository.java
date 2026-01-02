package com.vishal.springboot.jpa.repository;

import com.vishal.springboot.jpa.model.Course;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

@Repository
public class CourseJdbcRepository {
    private JdbcTemplate jdbcTemplate;

    public CourseJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static String INSERT_QUERY =
            """
                    INSERT INTO course (id, name, author) 
                    VALUES (?,?,?);
                    """;
    private static String DELETE_QUERY = """
            delete from course where id =?
            """;
    private static String SELECT_QUERY = """
            select * from course where id =?
            """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id){
        // ResultSet->Bean=>Row Mapper
       return  jdbcTemplate.queryForObject(
               SELECT_QUERY,
               new BeanPropertyRowMapper<>(Course.class),
               id
       );
    }
}
