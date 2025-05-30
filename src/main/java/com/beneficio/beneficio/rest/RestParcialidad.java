package com.beneficio.beneficio.rest;

import com.beneficio.beneficio.Service.ParcialidadService;
import com.beneficio.beneficio.model.Parcialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parcialidades")
public class RestParcialidad {

    @Autowired
    private ParcialidadService parcialidadService;

    // Crear una nueva parcialidad
    @PostMapping
    public Parcialidad crearParcialidad(@RequestBody Parcialidad parcialidad) {
        return parcialidadService.guardarParcialidad(parcialidad);
    }

    // Obtener todas las parcialidades
    @GetMapping
    public List<Parcialidad> obtenerTodasLasParcialidades() {
        return parcialidadService.obtenerTodasLasParcialidades();
    }

    // Obtener una parcialidad por ID
    @GetMapping("/{id}")
    public Optional<Parcialidad> obtenerParcialidadPorId(@PathVariable Long id) {
        return parcialidadService.obtenerParcialidadPorId(id);
    }

    // Eliminar una parcialidad por ID
    @DeleteMapping("/{id}")
    public void eliminarParcialidad(@PathVariable Long id) {
        parcialidadService.eliminarParcialidad(id);
    }
}
