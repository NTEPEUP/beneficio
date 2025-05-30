package com.beneficio.beneficio.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;

@Data
@Entity

@DynamicInsert
@Table(name = "parcialidad", schema = "agricultor")
public class Parcialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int peso;
    private String transporte;
    private Long transportista;
    private int id_pesaje;
    private int usuario;
    private LocalDate fecha;

}
