package com.jpa.hibernate.demojpaadvanced.repository;

import com.jpa.hibernate.demojpaadvanced.DemoJpaAdvancedApplication;
import com.jpa.hibernate.demojpaadvanced.entities.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = DemoJpaAdvancedApplication.class)
class CourseSpringDataRepositoryTests {

    @Autowired
    CourseSpringDataRepository repository;

    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void findById_CoursePresent() {
        Optional<Course> courseOptional = repository.findById(1001L);
        assertTrue(courseOptional.isPresent());
    }

    @Test
    public void findById_CourseNotPresent() {
        Optional<Course> courseOptional = repository.findById(2001L);
        assertFalse(courseOptional.isPresent());
    }

    @Test
    public void playingAroundWithSpringDataRepo() {
        /*Course course = new Course("Microservices with java");
        repository.save(course);
        course.setName("Microservices with java - updated");
        repository.save(course);*/

        logger.info("Courses -> {} ", repository.findAll());
        logger.info("Num of Courses -> {} ", repository.count());
    }

    @Test
    public void sort() {
        //sorting by name in desc order
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        logger.info("Sorted Courses desc. -> {} ", repository.findAll(sort));
    }

    @Test
    public void pagination() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Course> fistPage = repository.findAll(pageRequest);
        //Imprime cantidad de páginas y de qué instancia son. Ej. Course.
        logger.info("First page -> {} ", fistPage);
        logger.info("First page content -> {}", fistPage.getContent());

        Pageable secondPageable = fistPage.nextPageable();
        Page<Course> secondPage = repository.findAll(secondPageable);
        logger.info("Second page content -> {}", secondPage.getContent());
    }
}
