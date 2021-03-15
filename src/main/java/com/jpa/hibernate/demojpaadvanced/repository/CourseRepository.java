package com.jpa.hibernate.demojpaadvanced.repository;

import com.jpa.hibernate.demojpaadvanced.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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
        Course course1 = new Course("Web Services");
        em.persist(course1);
        em.flush();

        course1.setName("Web Services updated");
        em.flush();

        Course course2 = new Course("Angular JS");
        em.persist(course2);
        em.flush();

        em.detach(course2);

        course2.setName("Angular JS updated");
        em.flush();
    }
}
