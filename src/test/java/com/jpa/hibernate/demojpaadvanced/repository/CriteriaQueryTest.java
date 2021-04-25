package com.jpa.hibernate.demojpaadvanced.repository;

import com.jpa.hibernate.demojpaadvanced.DemoJpaAdvancedApplication;
import com.jpa.hibernate.demojpaadvanced.entities.Course;
import com.jpa.hibernate.demojpaadvanced.entities.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@SpringBootTest(classes = DemoJpaAdvancedApplication.class)
class CriteriaQueryTest {

    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void all_courses() {
        //Select c From Course c
        //Define de previous query using java
        /*
        1. Use Criteria Builder to create a Criteria Query returning the expected result object.
        2. Define roots for tables which are involver in the query
        3. Define Pedicates etc, using Criteria Builder
        4. Add Predicates etc, to the Criteria Query
        *
        * */

        //1.
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        //2.
        Root<Course> courseRoot = cq.from(Course.class);//It's called the root of the query (...From Course c)

        //5.
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

    @Test
    public void all_courses_having_course() {
        //Select c From Course c where name like '%course%'
        //Define de previous query using java
        /*
        1. Use Criteria Builder to create a Criteria Query returning the expected result object.
        2. Define roots for tables which are involver in the query
        3. Define Pedicates etc, using Criteria Builder
        4. Add Predicates etc, to the Criteria Query
        *
        * */

        //1.
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        //2.
        Root<Course> courseRoot = cq.from(Course.class);//It's called the root of the query (...From Course c)
        //3.
        Predicate likeCourse = cb.like(courseRoot.get("name"), "%course%");
        //4.
        cq.where(likeCourse);
        //5.
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }
}
