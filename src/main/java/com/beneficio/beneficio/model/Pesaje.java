package com.beneficio.beneficio.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import java.util.Date;

@Data
@Entity

@DynamicInsert
@Table(name = "pesaje", schema = "agricultor")
public class Pesaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer medida;
    private String peso_total_actual;
    @Column(nullable = true)
    private String estado;
    @Column(nullable = true)
    private Integer usuario;
    @Column(nullable = true)
    private Date fecha;
}
