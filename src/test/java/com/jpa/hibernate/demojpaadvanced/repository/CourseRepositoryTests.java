package com.jpa.hibernate.demojpaadvanced.repository;

import com.jpa.hibernate.demojpaadvanced.DemoJpaAdvancedApplication;
import com.jpa.hibernate.demojpaadvanced.entities.Course;
import com.jpa.hibernate.demojpaadvanced.entities.Review;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = DemoJpaAdvancedApplication.class)
class CourseRepositoryTests {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void findById_basic() {
        Course course = courseRepository.findById(1001L);
        assertEquals("JPA course", course.getName());
    }

    @Test
    @Transactional
    public void findById_firstLevelCacheDemo() {

        //The first time, it goes to the DB as normally it does, with a select * from...
        Course course = courseRepository.findById(1001L);
        logger.info("First course retrieved {}", course);

        //The Course entity is cached so the 2nd time it needs the course info a query is not fired into the DB.
        //It happens because we are in the same persistence context which is scoped by the @Transactional annotation
        //in this method. If we removed the @Transactional annotation 2 subsequent queries will be fired into the DB.

        Course course1 = courseRepository.findById(1001L);
        logger.info("First course retrieved again {}", course1);

        assertEquals("JPA course", course.getName());
        assertEquals("JPA course", course1.getName());
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
        logger.info("playWithEntityManager - start");
    }

    @Test
    @Transactional
    public void retrieveReviewsForCourse() {
        Course course = courseRepository.findById(1001L);
        logger.info("{}", course.getReviews());
    }

    @Test
    @Transactional
    public void retrieveCourseForReview() {
        Review review = em.find(Review.class, 5001L);
        logger.info("{}", review.getCourse());
    }

}
