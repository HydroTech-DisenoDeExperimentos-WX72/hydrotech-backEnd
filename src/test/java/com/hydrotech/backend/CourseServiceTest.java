package com.hydrotech.backend;

import com.hydrotech.backend.model.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CourseServiceTest {

    @Test
    public void testCourse() {
        //Given
        Course course = new Course(112133121L, "Curso de Java", "java.jpg", "Curso de Java", "100", "5", "10", "Programación", "20/12/24");

        //When
        long id_esperado = 112133121L;

        Assertions.assertEquals(id_esperado, course.getId());
    }

}