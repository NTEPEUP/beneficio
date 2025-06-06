package com.beneficio.beneficio.rest;

import com.beneficio.beneficio.Service.ParcialidadCafeService;
import com.beneficio.beneficio.model.ParcialidadCafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parcialidadesCafe")
public class RestParcialidadCafe {




    @Autowired
    private ParcialidadCafeService parcialidadCafeService;
    public RestParcialidadCafe(ParcialidadCafeService parcialidadCafeService) {
        this.parcialidadCafeService = parcialidadCafeService;
    }

    @PostMapping
    public ResponseEntity<ParcialidadCafe> registrarParcialidad(@RequestBody ParcialidadCafe parcialidadCafe) {
        ParcialidadCafe nuevaParcialidad = parcialidadCafeService.registrarParcialidad(parcialidadCafe);
        return ResponseEntity.ok(nuevaParcialidad);
    }



    // Obtener todas las parcialidades de café
    @GetMapping
    public List<ParcialidadCafe> obtenerTodasLasParcialidades() {
        return parcialidadCafeService.obtenerTodasLasParcialidades();
    }

    // Obtener una parcialidad de café por ID
    @GetMapping("/{id}")
    public ResponseEntity<ParcialidadCafe> obtenerParcialidadPorId(@PathVariable Long id) {
        Optional<ParcialidadCafe> parcialidad = parcialidadCafeService.obtenerParcialidadPorId(id);
        return parcialidad.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // Actualizar una parcialidad de café existente
    @PutMapping("/{id}")
    public ResponseEntity<ParcialidadCafe> actualizarParcialidad(@PathVariable Long id, @RequestBody ParcialidadCafe parcialidadActualizada) {
        try {
            ParcialidadCafe parcialidad = parcialidadCafeService.actualizarParcialidad(id, parcialidadActualizada);
            return ResponseEntity.ok(parcialidad);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una parcialidad de café por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarParcialidad(@PathVariable Long id) {
        parcialidadCafeService.eliminarParcialidad(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para listar parcialidades por id_cuenta
    @GetMapping("/por-cuenta/{idCuenta}")
    public List<ParcialidadCafe> obtenerParcialidadesPorIdCuenta(@PathVariable Long idCuenta) {
        return parcialidadCafeService.obtenerParcialidadesPorIdCuenta(idCuenta);
    }
}