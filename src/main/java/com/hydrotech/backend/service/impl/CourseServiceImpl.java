package com.hydrotech.backend.service.impl;

import com.hydrotech.backend.model.Course;
import com.hydrotech.backend.repository.CourseRepository;
import com.hydrotech.backend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the CourseService interface that interacts with the CourseRepository.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@Service
public class CourseServiceImpl implements CourseService {

    /**
     * Repository for managing Course entities.
     */
    @Autowired
    private CourseRepository courseRepository;

    /**
     * Creates a new course.
     *
     * @param course The course to be created.
     * @return The created course.
     */
    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
}
