package com.jpa.hibernate.demojpaadvanced.repository;

import com.jpa.hibernate.demojpaadvanced.DemoJpaAdvancedApplication;
import com.jpa.hibernate.demojpaadvanced.entities.Passport;
import com.jpa.hibernate.demojpaadvanced.entities.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest(classes = DemoJpaAdvancedApplication.class)
class StudentRepositoryTests {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = em.find(Student.class, 2002L);
        logger.info("Student -> {}", student);
        logger.info("Passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent() {
        Passport passport = em.find(Passport.class, 4001L);
        logger.info("Student -> {}", passport);
        logger.info("Passport -> {}", passport.getStudent());
    }

    @Test
    @Transactional //Persistence Context. The changes below are made in the Persistence Context (PC).
    // In Hibernate, Session (Session Factory) = Persistence Context.
    // If we extract the below LoCs into a new method which actually uses the EM, then the PC will be provided by
    // the Repository, studentRepository.
    public void someTest() {

        //DB Op 1: Retrieve student
        Student student = em.find(Student.class, 2002L);

        //DB Op 2: Retrieve passport
        Passport passport = student.getPassport();

        //DB Op 3: Update passport
        passport.setNumber("E9101112");

        //DB Op 4: Update student
        student.setName("Jorge - updtd");
    }// killed the PC.
}
