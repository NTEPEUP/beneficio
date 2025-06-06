package com.beneficio.beneficio.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;

@Data
@Entity
@DynamicInsert
@Table(name = "cuenta", schema = "cafe")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cuenta;

    @Column(nullable = true)
    private Integer agricultor;

    @Column(nullable = true)
    private Long id_pesaje;

    @Column(nullable = true)
    private Integer id_estado;

    @Column(nullable = true)
    private float peso_enviado;

    @Column(nullable = true)
    private float peso_obtenido;

    @Column(nullable = true)
    private float diferencia_total; // Ahora se persiste en la base de datos

    @Column(nullable = true)
    private LocalDate fecha;

    // Método para calcular la diferencia antes de guardar o actualizar
    @PrePersist
    @PreUpdate
    private void calcularDiferenciaTotal() {
        this.diferencia_total = this.peso_enviado - this.peso_obtenido;
    }
}