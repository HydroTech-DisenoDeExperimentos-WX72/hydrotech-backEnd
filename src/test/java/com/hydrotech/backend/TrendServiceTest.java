package com.hydrotech.backend;

import com.hydrotech.backend.model.Trend;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrendServiceTest {

    @Test
    public void testTrend() {
        //Given
        Trend trend = new Trend(11213134153L,"Saltar la cuerda");

        //When
        String nombre_esperado = "Cursos de Java";

        Assertions.assertTrue(nombre_esperado != trend.getName());
    }

}