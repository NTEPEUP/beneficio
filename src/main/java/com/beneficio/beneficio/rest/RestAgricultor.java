package com.beneficio.beneficio.rest;

import com.beneficio.beneficio.Service.AgricultorService;
import com.beneficio.beneficio.model.Agricultor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/agricultores")
public class RestAgricultor {

    private final AgricultorService agricultorService;

    @Autowired
    public RestAgricultor(AgricultorService agricultorService) {
        this.agricultorService = agricultorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agricultor> getAgricultorById(@PathVariable Long id) {
        Optional<Agricultor> agricultor = agricultorService.getAgricultorById(id);
        return agricultor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Agricultor> saveAgricultor(@RequestBody Agricultor agricultor) {
        Agricultor savedAgricultor = agricultorService.saveAgricultor(agricultor);
        return ResponseEntity.ok(savedAgricultor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgricultorById(@PathVariable Long id) {
        agricultorService.deleteAgricultorById(id);
        return ResponseEntity.noContent().build();
    }
}