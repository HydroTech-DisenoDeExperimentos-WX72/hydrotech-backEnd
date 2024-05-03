package com.hydrotech.backend;

import com.hydrotech.backend.model.Article;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArticleServiceTest {

    @Test
    public void testArticle() {
        //Given
        Article article = new Article(1121314143123121L,"java.jpg", "Curso de Java", "20/12/24", "Curso de Java", "cuos.com");
        Article article2 = new Article(1114313546315L,"java.jpg", "Curso de Kotlin", "22/12/24", "Curso de Kotlin", "cuos.com");


        //When
        String titulo_1 = article.getTitulo();
        String titulo_2 = article2.getTitulo();

        Assertions.assertFalse(titulo_1 == titulo_2);
    }

}