package com.greengrow.backend.model;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="imagen", length =250, nullable=false)
    private String imagen;

    @Column(name="titulo", length =250, nullable=false)
    private String titulo;

    @Column(name="fecha", length =10, nullable=false)
    private String fecha;

    @Column(name="descripcion", length =250, nullable=false)
    private String descripcion;

    @Column(name="enlace", length =250, nullable=false)
    private String enlace;

}
