package com.hydrotech.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hydrotech.backend.controller.CourseController;
import com.hydrotech.backend.model.Course;
import com.hydrotech.backend.repository.CourseRepository;
import com.hydrotech.backend.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(CourseController.class)
public class CourseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @MockBean
    private CourseRepository courseRepository;
    private Course course2;

    @BeforeEach
    void setUp() {
        // Configurar comportamientos de los mocks
         course2 = Course.builder()
                .id(1L)
                .name("Curso de hidroponia")
                .image("a.com")
                .description("Curso de enseñanza")
                .price("100")
                .rating("5")
                .duration("5")
                .category("Control")
                .date("20/12/24")
                .build();
    }


    @Test
    public void testCreateCourse() throws Exception {

        when(courseService.createCourse(any(Course.class))).thenReturn(course2);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/hydro-tech/v1/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(course2)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(course2.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(course2.getDescription()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(course2.getPrice()))
                .andDo(print());
    }

    //TestGetAll
    @Test
    public void testGetAllCourses() throws Exception {
        when(courseRepository.findAll()).thenReturn(List.of(course2));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/hydro-tech/v1/courses"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(course2.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value(course2.getDescription()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(course2.getPrice()))
                .andDo(print());
    }

    //TestById
    /*@Test
    public void testGetCourseById() throws Exception {

        when(courseRepository.findById(1L)).thenReturn(java.util.Optional.of(course2));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/hydro-tech/v1/courses/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(course2.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(course2.getDescription()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(course2.getPrice()))
                .andDo(print());
    }*/
}

