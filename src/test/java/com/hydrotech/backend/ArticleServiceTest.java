package com.hydrotech.backend;

import com.hydrotech.backend.model.Article;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArticleServiceTest {

    @Test
    public void testArticle() {
        //Given
        Article article = new Article(1121314143123121L,"java.jpg", "Curso de Java", "20/12/24", "Curso de Java", "cuos.com");

        //When
        String titulo_esperado = "Cursos de Java";

        Assertions.assertFalse(titulo_esperado == article.getTitulo());
    }

}