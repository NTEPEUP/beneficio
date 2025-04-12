package com.beneficio.beneficio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
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
    private String estado;
    private String observaciones;
    private int usuario;
}
