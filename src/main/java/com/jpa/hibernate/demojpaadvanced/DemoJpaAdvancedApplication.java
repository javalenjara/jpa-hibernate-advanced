package com.jpa.hibernate.demojpaadvanced;

import com.jpa.hibernate.demojpaadvanced.entities.Course;
import com.jpa.hibernate.demojpaadvanced.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJpaAdvancedApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final CourseRepository courseRepository;

    @Autowired
    public DemoJpaAdvancedApplication(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoJpaAdvancedApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Course course = courseRepository.findById(1001L);
//        logger.info("Course 1001 {}", course);
//
//        //courseRepository.deleteById(1001L);
//
//        courseRepository.save(new Course("Microservices"));

        courseRepository.playWithEntityManager();
    }
}
