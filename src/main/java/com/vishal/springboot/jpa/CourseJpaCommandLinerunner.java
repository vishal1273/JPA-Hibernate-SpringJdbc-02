package com.vishal.springboot.jpa;

import com.vishal.springboot.jpa.model.Course;
import com.vishal.springboot.jpa.repository.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJpaCommandLinerunner implements CommandLineRunner {
    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJpaRepository.insert(new Course(1, "Learn AWS", "Vishal"));
        courseJpaRepository.insert(new Course(2, "Learn Spring Boot", "Vishal"));
        courseJpaRepository.insert(new Course(3, "Learn Hibernate", "Ranga"));
        courseJpaRepository.insert(new Course(4, "Learn Microservices", "In28Minutes"));
        courseJpaRepository.insert(new Course(5, "Learn Docker", "DevOps Team"));

        courseJpaRepository.deleteById(1l);
        System.out.println(courseJpaRepository.findById(2l));
        System.out.println(courseJpaRepository.findById(3l));
        System.out.println(courseJpaRepository.findById(4l));
    }
}
