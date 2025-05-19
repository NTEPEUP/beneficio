package com.beneficio.beneficio.Service;

import com.beneficio.beneficio.model.Cuenta;
import com.beneficio.beneficio.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    // Crear o guardar una cuenta
    public Cuenta guardarCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    // Obtener todas las cuentas
    public List<Cuenta> obtenerTodasLasCuentas() {
        return cuentaRepository.findAll();
    }

    // Obtener una cuenta por ID
    public Optional<Cuenta> obtenerCuentaPorId(Long id) {
        return cuentaRepository.findById(id);
    }

    // Actualizar una cuenta
    public Cuenta actualizarCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    // Eliminar una cuenta por ID
    public void eliminarCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }
}