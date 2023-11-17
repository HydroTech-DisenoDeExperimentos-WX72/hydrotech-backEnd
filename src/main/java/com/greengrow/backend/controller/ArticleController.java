package com.greengrow.backend.controller;

import com.greengrow.backend.model.Article;
import com.greengrow.backend.repository.ArticleRepository;
import com.greengrow.backend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/green-grow/v1")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    //URL: http://localhost:8080/api/green-grow/v1/articles
    //Method: GET
    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAllArticles() {
        return new ResponseEntity<List<Article>>(articleRepository.findAll(), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/green-grow/v1/articles
    //Method: POST
    @PostMapping("/articles")
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        try {
            validateArticle(article);
            //existsByNameAndPrice(article);
            return new ResponseEntity<Article>(articleService.createArticle(article), HttpStatus.CREATED);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private void validateArticle(Article article){
        if(article.getImagen() == null || article.getImagen().isEmpty()){
            throw new RuntimeException("La imagen del artículo es obligatoria");
        }

        if(article.getImagen().length() > 250){
            throw new RuntimeException("La imagen del artículo no puede tener más de 250 caracteres");
        }

        if(article.getTitulo() == null || article.getTitulo().isEmpty()){
            throw new RuntimeException("El título del artículo es obligatorio");
        }

        if(article.getTitulo().length() > 250){
            throw new RuntimeException("El título del artículo no puede tener más de 250 caracteres");
        }

        if(article.getDescripcion() == null || article.getDescripcion().isEmpty()){
            throw new RuntimeException("La descripción del artículo es obligatoria");
        }

        if(article.getDescripcion().length() > 250){
            throw new RuntimeException("La descripción del artículo no puede tener más de 250 caracteres");
        }

        if(article.getFecha() == null || article.getFecha().isEmpty()){
            throw new RuntimeException("La fecha del artículo es obligatoria");
        }

        if(article.getFecha().length() > 10){
            throw new RuntimeException("La fecha del artículo no puede tener más de 10 caracteres");
        }

        if(article.getEnlace() == null || article.getEnlace().isEmpty()){
            throw new RuntimeException("El enlace del artículo es obligatorio");
        }

        if(article.getEnlace().length() > 250){
            throw new RuntimeException("El enlace del artículo no puede tener más de 250 caracteres");
        }

    }
}
