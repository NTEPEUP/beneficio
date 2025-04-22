package com.beneficio.beneficio.rest;

import com.beneficio.beneficio.Service.TransporteService;
import com.beneficio.beneficio.model.Transporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/transporte")
public class RestTransporte {

    @Autowired
    private TransporteService transporteService;

    // Crear un nuevo transporte
    @PostMapping
    public ResponseEntity<Transporte> createTransporte(@RequestBody Transporte transporte) {
        Transporte nuevoTransporte = transporteService.createTransporte(transporte);
        return ResponseEntity.ok(nuevoTransporte);
    }

    // Obtener todos los transportes
    @GetMapping
    public ResponseEntity<List<Transporte>> getAllTransportes() {
        List<Transporte> transportes = transporteService.getAllTransportes();
        return ResponseEntity.ok(transportes);
    }

    // Obtener un transporte por su placa
    @GetMapping("/{placa}")
    public ResponseEntity<Transporte> getTransporteById(@PathVariable String placa) {
        return transporteService.getTransporteById(placa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un transporte existente
   /* @PutMapping("/{placa}")
    public ResponseEntity<Transporte> updateTransporte(@PathVariable String placa, @RequestBody Transporte transporteDetails) {
        try {
            Transporte transporteActualizado = transporteService.updateTransporte(placa, transporteDetails);
            return ResponseEntity.ok(transporteActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }*/

    @PutMapping("/{placa}")
    public ResponseEntity<Transporte> updateTransporte(
            @PathVariable String placa,
            @RequestBody Transporte transporteDetails) {
        try {
            Transporte transporteActualizado = transporteService.updateTransporte(placa, transporteDetails);
            return ResponseEntity.ok(transporteActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un transporte por su placa
    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> deleteTransporte(@PathVariable String placa) {
        transporteService.deleteTransporte(placa);
        return ResponseEntity.noContent().build();
    }
}
