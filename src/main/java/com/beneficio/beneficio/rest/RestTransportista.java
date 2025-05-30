package com.beneficio.beneficio.rest;


import com.beneficio.beneficio.Service.TransportistaService;
import com.beneficio.beneficio.model.Transporte;
import com.beneficio.beneficio.model.Transportista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transportista")
public class RestTransportista {

    @Autowired
    private TransportistaService transportistaService;

    // Método para obtener transportistas por usuario
    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<List<Transportista>> getTransportistasPorUsuario(@PathVariable Integer usuario) {
        List<Transportista> transportistas = transportistaService.getTransportistasPorUsuario(usuario);
        return ResponseEntity.ok(transportistas);
    }

    // Crear un nuevo transportista
    @PostMapping
    public ResponseEntity<Transportista> createTransportista(@RequestBody Transportista transportista) {
        Transportista nuevoTransportista = transportistaService.createTransportista(transportista);
        return ResponseEntity.ok(nuevoTransportista);
    }

    // Obtener todos los transportistas
    @GetMapping
    public ResponseEntity<List<Transportista>> getAllTransportistas() {
        List<Transportista> transportistas = transportistaService.getAllTransportistas();
        return ResponseEntity.ok(transportistas);
    }

    // Obtener un transportista por su CUI
    @GetMapping("/{cui}")
    public ResponseEntity<Transportista> getTransportistaById(@PathVariable long cui) {
        return transportistaService.getTransportistaById(cui)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un transportista existente
    /*@PutMapping("/{cui}")
    public ResponseEntity<Transportista> updateTransportista(@PathVariable long cui, @RequestBody Transportista transportistaDetails) {
        try {
            Transportista transportistaActualizado = transportistaService.updateTransportista(cui, transportistaDetails);
            return ResponseEntity.ok(transportistaActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }*/
    @PutMapping("/{cui}")
    public ResponseEntity<Transportista> updateTransportista(
            @PathVariable long cui,
            @RequestBody Transportista transportistaDetails) {
        try {
            Transportista transportistaActualizado = transportistaService.updateTransportista(cui, transportistaDetails);
            return ResponseEntity.ok(transportistaActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un transportista por su CUI
    @DeleteMapping("/{cui}")
    public ResponseEntity<Void> deleteTransportista(@PathVariable long cui) {
        transportistaService.deleteTransportista(cui);
        return ResponseEntity.noContent().build();
    }

}
