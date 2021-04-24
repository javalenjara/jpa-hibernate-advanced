package com.jpa.hibernate.demojpaadvanced.repository;

import com.jpa.hibernate.demojpaadvanced.entities.Course;
import com.jpa.hibernate.demojpaadvanced.entities.Employee;
import com.jpa.hibernate.demojpaadvanced.entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    private EntityManager em;

    @Autowired
    public EmployeeRepository(EntityManager em) {
        this.em = em;
    }

    public void insert(Employee employee){
        em.persist(employee);
    }

    public List<Employee> retrieveAllEmployees(){
        return em.createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList();
    }
}
