package com.jpa.hibernate.demojpaadvanced.repository;

import com.jpa.hibernate.demojpaadvanced.entities.Student;
import com.jpa.hibernate.demojpaadvanced.entities.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    private EntityManager em;

    @Autowired
    public StudentRepository(EntityManager em) {
        this.em = em;
    }

    public Student findById(Long id){
        return em.find(Student.class, id);
    }

    public Student save(Student student){
        if (student.getId() == null){
            em.persist(student);
        }
        else {
            em.merge(student);
        }
        return student;
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("Marina");
        student.setPassport(passport);
        em.persist(student);
    }
}
