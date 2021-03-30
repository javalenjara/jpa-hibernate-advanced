package com.jpa.hibernate.demojpaadvanced.repository;

import com.jpa.hibernate.demojpaadvanced.DemoJpaAdvancedApplication;
import com.jpa.hibernate.demojpaadvanced.entities.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest(classes = DemoJpaAdvancedApplication.class)
class NativeQueriesTest {

    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void native_queries_basic() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    public void native_queries_with_parameters() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = ?", Course.class);
        query.setParameter(1, 1001L);
        List resultList = query.getResultList();
        logger.info("Select c From Course c Where id = ?-> {}", resultList);
    }

    @Test
    public void native_queries_with_named_parameters() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = :id", Course.class);
        query.setParameter("id", 1001L);
        List resultList = query.getResultList();
        logger.info("Select c From Course c Where id = :id-> {}", resultList);
    }

    @Test
    @Transactional
    //Los NativeQueries son una buena alternativa para hacer updates masivos como en el ejemplo. Ya que hacerlo sobre JPA
    // implicaría tomar cada fila y actualizarla
    public void native_queries_to_update() {
        Query query = em.createNativeQuery("UPDATE COURSE SET last_updated_date = SYSDATE()", Course.class);
        int numberOfRowsUpdated = query.executeUpdate();
        logger.info("numberOfRowsUpdated -> {}", numberOfRowsUpdated);
    }

}
