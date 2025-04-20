package com.beneficio.beneficio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serializable;
import java.time.LocalDate;



@DynamicInsert
@Entity
@Data
@Table(name="transportista", schema = "agricultor")


public class Transportista implements Serializable {


    @Id
    private long cui;
    private String nombre;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "tipo_licencia")
    private String tipoLicencia;
    @Column(name = "fecha_vencimiento_licencia")
    private LocalDate fechaVencimientoLicencia;
    @Column (nullable = true)
    private String estado;
    @Column (nullable = true)
    private String observaciones;
    @Column (nullable = true)
    private Integer usuario;
}
