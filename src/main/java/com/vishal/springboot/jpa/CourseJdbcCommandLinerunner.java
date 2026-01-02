package com.vishal.springboot.jpa;

import com.vishal.springboot.jpa.model.Course;
import com.vishal.springboot.jpa.repository.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLinerunner implements CommandLineRunner {
    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1, "Learn AWS", "Vishal"));
        courseJdbcRepository.insert(new Course(2, "Learn Spring Boot", "Vishal"));
        courseJdbcRepository.insert(new Course(3, "Learn Hibernate", "Ranga"));
        courseJdbcRepository.insert(new Course(4, "Learn Microservices", "In28Minutes"));
        courseJdbcRepository.insert(new Course(5, "Learn Docker", "DevOps Team"));

        courseJdbcRepository.deleteById(1);
        System.out.println(courseJdbcRepository.findById(2));
        System.out.println(courseJdbcRepository.findById(3));
        System.out.println(courseJdbcRepository.findById(4));
    }
}
