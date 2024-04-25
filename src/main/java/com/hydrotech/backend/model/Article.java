package com.hydrotech.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="articles")
public class Article {

    /**
     * The unique identifier for the article.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The image associated with the article.
     */
    @Column(name="image", length =250, nullable=false)
    private String imagen;

    /**
     * The title of the article.
     */
    @Column(name="title", length =250, nullable=false)
    private String titulo;

    /**
     * The publication date of the article.
     */
    @Column(name="date", length =10, nullable=false)
    private String fecha;

    /**
     * The description or content of the article.
     */
    @Column(name="description", length =250, nullable=false)
    private String descripcion;

    /**
     * The link or URL associated with the article.
     */
    @Column(name="link", length =250, nullable=false)
    private String enlace;

}