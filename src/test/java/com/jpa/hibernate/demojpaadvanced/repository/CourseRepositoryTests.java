package com.jpa.hibernate.demojpaadvanced.repository;

import com.jpa.hibernate.demojpaadvanced.DemoJpaAdvancedApplication;
import com.jpa.hibernate.demojpaadvanced.entities.Course;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = DemoJpaAdvancedApplication.class)
class CourseRepositoryTests {

    @Autowired
    CourseRepository courseRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void findById_basic() {
        Course course = courseRepository.findById(1001L);
        assertEquals("JPA course", course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById_basic() {
        courseRepository.deleteById(1002L);
        assertNull(courseRepository.findById(1002L));
    }

    @Test
    @DirtiesContext
    public void save_basic() {
        //get a course and check its initial state.
        Course course = courseRepository.findById(1001L);
        assertEquals("JPA course", course.getName());

        //update de details of it
        course.setName("JPA Course updated");
        courseRepository.save(course);

        //check the value
        Course courseUpdated = courseRepository.findById(1001L);
        assertEquals("JPA Course updated", courseUpdated.getName());
    }

    @Test
    @DirtiesContext
    public void playWithEntityManager() {
        courseRepository.playWithEntityManager();
        logger.info(() -> "playWithEntityManager - start");
    }

}
