package com.jpa.hibernate.demojpaadvanced;

import com.jpa.hibernate.demojpaadvanced.entities.Review;
import com.jpa.hibernate.demojpaadvanced.repository.CourseRepository;
import com.jpa.hibernate.demojpaadvanced.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoJpaAdvancedApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public DemoJpaAdvancedApplication(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoJpaAdvancedApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //studentRepository.saveStudentWithPassport();
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("5", "Great Hands-on"));
        reviews.add(new Review("5", "Hats off"));
        courseRepository.addReviewsForCourse(1003L, reviews);
    }
}
