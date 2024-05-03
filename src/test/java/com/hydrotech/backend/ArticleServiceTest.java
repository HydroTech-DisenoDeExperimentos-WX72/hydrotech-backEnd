package com.hydrotech.backend;

import com.hydrotech.backend.model.Article;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArticleServiceTest {

    @Test
    public void testArticle() {
        //Given
        Article article = new Article(1121314143123121L,"plantacion.jpg", "Curso de plantacion de papas", "20/12/24", "Curso de plantacion de papas", "cuos.com");

        //When
        String titulo_esperado = "Cursos de plantacion de papas";

        Assertions.assertFalse(titulo_esperado == article.getTitulo());
    }

}