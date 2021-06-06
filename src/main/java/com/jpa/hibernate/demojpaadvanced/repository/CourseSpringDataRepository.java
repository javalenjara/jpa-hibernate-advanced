package com.jpa.hibernate.demojpaadvanced.repository;

import com.jpa.hibernate.demojpaadvanced.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

    List<Course> findByName(String name);
    List<Course> countByName(String name);
    List<Course> findByNameAndId(String name, Long id);
    List<Course> findByNameOrderByIdDesc(String name);
    List<Course> deleteByName(String name);

    @Query("Select c From Course c Where name Like '%course'")
    List<Course> courseWithCourseInName();

    @Query(value = "Select * From Course c Where name Like '%course'", nativeQuery = true)
    List<Course> courseWithCourseInNameUsingNative();

    @Query(name = "query_get_all_courses")
    List<Course> courseWithCourseInNameUsingNamedQuery();

}