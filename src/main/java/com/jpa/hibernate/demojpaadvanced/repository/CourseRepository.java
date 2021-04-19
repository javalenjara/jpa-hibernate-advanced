package com.jpa.hibernate.demojpaadvanced.repository;

import com.jpa.hibernate.demojpaadvanced.entities.Course;
import com.jpa.hibernate.demojpaadvanced.entities.Review;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.slf4j.Logger;

@Repository
@Transactional
public class CourseRepository {

    private EntityManager em;

    @Autowired
    public CourseRepository(EntityManager em) {
        this.em = em;
    }

    public Course findById(Long id){
        return em.find(Course.class, id);
    }

    public Course save(Course course){
        if (course.getId() == null){
            em.persist(course);
        }
        else {
            em.merge(course);
        }
        return course;
    }

    public void deleteById(Long id){
        Course course = findById(id);
        em.remove(course);
    }

    public void playWithEntityManager() {
        Course course1 = new Course("Web Services part 2");
        em.persist(course1);

        Course course2 = findById(1001L);
        course2.setName("JPA course - updated");
    }

    public void addReviewsForCourse() {
        //get te course 1003
        Logger logger = LoggerFactory.getLogger(this.getClass());
        Course course = findById(1003L);
        logger.info("course.getReviews() -> {}", course.getReviews());

        //add 2 reviews to it
        Review review1 = new Review("5", "Great Hands-on");
        Review review2 = new Review("5", "Hatsoff");

        //creating the relationship
        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        //save it to the DB
        em.persist(review1);
        em.persist(review2);
    }
}
