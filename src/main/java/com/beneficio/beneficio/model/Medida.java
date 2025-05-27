package com.beneficio.beneficio.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

@Data
@Entity

@DynamicInsert
@Table(name = "medida", schema = "agricultor")
public class Medida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
}
