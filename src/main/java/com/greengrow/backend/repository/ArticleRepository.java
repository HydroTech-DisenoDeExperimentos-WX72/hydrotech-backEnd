package com.greengrow.backend.repository;

import com.greengrow.backend.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Boolean existsByImagenAndTituloAndFechaAndDescripcion(String imagen, String titulo, String fecha, String descripcion);
}
