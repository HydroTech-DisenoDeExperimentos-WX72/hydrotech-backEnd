package com.hydrotech.backend;

import com.hydrotech.backend.model.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CourseServiceTest {

    @Test
    public void testCourse() {
        //Given
        Course course = new Course(14525424234521L, "Curso de C++", "C++.jpg", "Curso de C++", "100", "5", "10", "Programación", "20/12/24");
        Course course2 = new Course(11211234123L, "Curso de Pyhton", "Pyhton.jpg", "Curso de Pyhton", "100", "5", "10", "Programación", "20/12/24");


        //When
        long id_1 = course.getId();
        long id_2 = course2.getId();

        Assertions.assertTrue(id_1 != id_2);
    }

}