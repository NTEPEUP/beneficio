package com.beneficio.beneficio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;


@Data
@Entity

@DynamicInsert
@Table(name = "transporte",schema = "agricultor")
public class Transporte {

    @Id
    private String placa;
    @Column(name = "tipo_placa")
    private int tipo_placa;
    private String marca;
    private String color;
    private String linea;
    private String modelo;

    @Column(nullable = true) // Permitir valores nulos
    private String estado;

    @Column(nullable = true) // Permitir valores nulos
    private String observaciones;

    @Column(nullable = true) // Permitir valores nulos
    private Integer usuario; // Cambiar a Integer para permitir nulos
}
