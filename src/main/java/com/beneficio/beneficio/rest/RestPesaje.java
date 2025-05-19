package com.beneficio.beneficio.rest;

import com.beneficio.beneficio.Service.PesajeService;
import com.beneficio.beneficio.model.Pesaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pesaje")
public class RestPesaje {

    @Autowired
    private PesajeService pesajeService;

    // Crear un nuevo pesaje
    @PostMapping
    public ResponseEntity<Pesaje> createPesaje(@RequestBody Pesaje pesaje) {
        Pesaje nuevoPesaje = pesajeService.createPesaje(pesaje);
        return ResponseEntity.ok(nuevoPesaje);
    }

    // Obtener todos los pesajes
    @GetMapping
    public ResponseEntity<List<Pesaje>> getAllPesajes() {
        List<Pesaje> pesajes = pesajeService.getAllPesajes();
        return ResponseEntity.ok(pesajes);
    }

    // Obtener un pesaje por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Pesaje> getPesajeById(@PathVariable Long id) {
        Optional<Pesaje> pesaje = pesajeService.getPesajeById(id);
        return pesaje.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un pesaje existente
    @PutMapping("/{id}")
    public ResponseEntity<Pesaje> updatePesaje(@PathVariable Long id, @RequestBody Pesaje pesajeDetails) {
        try {
            Pesaje pesajeActualizado = pesajeService.updatePesaje(id, pesajeDetails);
            return ResponseEntity.ok(pesajeActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un pesaje por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePesaje(@PathVariable Long id) {
        pesajeService.deletePesaje(id);
        return ResponseEntity.noContent().build();
    }
}