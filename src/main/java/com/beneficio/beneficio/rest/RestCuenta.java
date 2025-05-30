package com.beneficio.beneficio.rest;

import com.beneficio.beneficio.model.Cuenta;
import com.beneficio.beneficio.Service.CuentaService;
import com.beneficio.beneficio.model.Transporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class RestCuenta {

    @Autowired
    private CuentaService cuentaService;


    // Método para obtener cuentas por agricultor
    @GetMapping("/agricultor/{agricultor}")
    public ResponseEntity<List<Cuenta>> getCuentasPorAgricultor(@PathVariable Integer agricultor) {
        List<Cuenta> cuentas = cuentaService.getCuentasPorAgricultor(agricultor);
        return ResponseEntity.ok(cuentas);
    }


    // Crear o guardar una cuenta
    @PostMapping
    public Cuenta guardarCuenta(@RequestBody Cuenta cuenta) {
        return cuentaService.guardarCuenta(cuenta);
    }

    // Obtener todas las cuentas
    @GetMapping
    public List<Cuenta> obtenerTodasLasCuentas() {
        return cuentaService.obtenerTodasLasCuentas();
    }

    // Obtener una cuenta por ID
    @GetMapping("/{id}")
    public Optional<Cuenta> obtenerCuentaPorId(@PathVariable Long id) {
        return cuentaService.obtenerCuentaPorId(id);
    }

    // Actualizar una cuenta
    @PutMapping
    public Cuenta actualizarCuenta(@RequestBody Cuenta cuenta) {
        return cuentaService.actualizarCuenta(cuenta);
    }

    @PutMapping("peso/{cuenta}")
    public ResponseEntity<Cuenta> updateCuenta(@PathVariable Long cuenta, @RequestBody Cuenta cuentaDetails) {
        try {
            Cuenta cuentaActualizada = cuentaService.updateCuenta(cuenta, cuentaDetails);
            return ResponseEntity.ok(cuentaActualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una cuenta por ID
    @DeleteMapping("/{id}")
    public void eliminarCuenta(@PathVariable Long id) {
        cuentaService.eliminarCuenta(id);
    }
}