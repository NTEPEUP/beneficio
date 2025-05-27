package com.beneficio.beneficio.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;

@Data
@Entity

@DynamicInsert
@Table(name = "parcialidad_cafe", schema = "cafe")


public class ParcialidadCafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_cuenta", nullable = false)
    private Cuenta cuenta;
    private Long id_transportista;
    private String id_transporte;
    private LocalDate id_fecha_recepcion_parcialidad;
    private double peso_enviado;
    private double peso_bascula;
    private double diferencia_peso;
    private LocalDate fecha_peso_bascula;
    private Long usuario;


    // Getters y Setters
}
