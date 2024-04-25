package com.hydrotech.backend.service;

import com.hydrotech.backend.model.Course;


public interface CourseService {

    /**
     * Creates a new course.
     *
     * @param course The course to be created.
     * @return The created course.
     */
    Course createCourse(Course course);
}