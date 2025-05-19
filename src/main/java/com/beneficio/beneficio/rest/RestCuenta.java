package com.beneficio.beneficio.controller;

import com.beneficio.beneficio.model.Cuenta;
import com.beneficio.beneficio.Service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class RestCuenta {

    @Autowired
    private CuentaService cuentaService;

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

    // Eliminar una cuenta por ID
    @DeleteMapping("/{id}")
    public void eliminarCuenta(@PathVariable Long id) {
        cuentaService.eliminarCuenta(id);
    }
}