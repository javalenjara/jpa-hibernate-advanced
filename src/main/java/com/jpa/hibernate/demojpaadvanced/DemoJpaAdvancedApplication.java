package com.jpa.hibernate.demojpaadvanced;

import com.jpa.hibernate.demojpaadvanced.entities.*;
import com.jpa.hibernate.demojpaadvanced.repository.CourseRepository;
import com.jpa.hibernate.demojpaadvanced.repository.EmployeeRepository;
import com.jpa.hibernate.demojpaadvanced.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoJpaAdvancedApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public DemoJpaAdvancedApplication(CourseRepository courseRepository, StudentRepository studentRepository,
                                      EmployeeRepository employeeRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoJpaAdvancedApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //studentRepository.saveStudentWithPassport();
//        List<Review> reviews = new ArrayList<>();
//        reviews.add(new Review("5", "Great Hands-on"));
//        reviews.add(new Review("5", "Hats off"));
//        courseRepository.addReviewsForCourse(1003L, reviews);
        //studentRepository.insertStudentAndCourse();
//        studentRepository.insertStudentAndCourse(
//                new Student("Jack"),
//                new Course("Microservices"));
        FullTimeEmployee fte = new FullTimeEmployee("Jack", new BigDecimal("10000"));
        PartTimeEmployee pte = new PartTimeEmployee("Jill", new BigDecimal("50"));
        employeeRepository.insert(pte);
        employeeRepository.insert(fte);

        logger.info("All Employees -> {}", employeeRepository.retrieveAllEmployees());

    }
}
