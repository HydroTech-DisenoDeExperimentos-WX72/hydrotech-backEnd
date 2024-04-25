package com.hydrotech.backend.repository;

import com.hydrotech.backend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {

    /**
     * Checks if a course with the specified name and price already exists.
     *
     * @param name  The name of the course.
     * @param price The price of the course.
     * @return True if a course with the specified name and price exists, false otherwise.
     */
    Boolean existsByNameAndPrice(String name, String price);
}
