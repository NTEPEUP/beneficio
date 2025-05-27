package com.beneficio.beneficio.User;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "role", schema = "cafe")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
