package com.jpa.hibernate.demojpaadvanced.repository;

import com.jpa.hibernate.demojpaadvanced.entities.*;
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

//    public List<Employee> retrieveAllEmployees(){
//        return em.createQuery("SELECT e FROM Employee e", Employee.class)
//                .getResultList();
//    }

    public List<PartTimeEmployee> retrieveAllPartTimeEmployees(){
        return em.createQuery("SELECT e FROM PartTimeEmployee e", PartTimeEmployee.class)
                .getResultList();
    }

    public List<FullTimeEmployee> retrieveAllFullTimeEmployees(){
        return em.createQuery("SELECT e FROM FullTimeEmployee e", FullTimeEmployee.class)
                .getResultList();
    }
}
