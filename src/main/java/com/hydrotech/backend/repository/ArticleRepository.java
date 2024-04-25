package com.hydrotech.backend.repository;

import com.hydrotech.backend.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepository extends JpaRepository<Article, Long> {

    /**
     * Checks if an article with the specified image, title, date, and description already exists.
     *
     * @param imagen The image of the article.
     * @param titulo The title of the article.
     * @param fecha  The date of the article.
     * @param descripcion The description of the article.
     * @return True if an article with the specified attributes exists, false otherwise.
     */
    Boolean existsByImagenAndTituloAndFechaAndDescripcion(String imagen, String titulo, String fecha, String descripcion);
}
