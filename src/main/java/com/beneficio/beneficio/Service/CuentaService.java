package com.beneficio.beneficio.Service;

import com.beneficio.beneficio.model.Cuenta;
import com.beneficio.beneficio.model.Transporte;
import com.beneficio.beneficio.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    // Método para listar cuentas por agricultor
    public List<Cuenta> getCuentasPorAgricultor(Integer agricultor) {
        return cuentaRepository.findByAgricultor(agricultor);
    }

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


    public Cuenta updateCuenta(Long cuenta, Cuenta cuentaDetails) {
        Cuenta cuenta1 = cuentaRepository.findById(cuenta)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada con ID: " + cuenta));

        // Actualizar solo los campos proporcionados
        if (cuentaDetails.getAgricultor() != null) {
            cuenta1.setAgricultor(cuentaDetails.getAgricultor());
        }
        if (cuentaDetails.getId_pesaje() != null) {
            cuenta1.setId_pesaje(cuentaDetails.getId_pesaje());
        }
        if (cuentaDetails.getId_estado() != null) {
            cuenta1.setId_estado(cuentaDetails.getId_estado());
        }
        if (cuentaDetails.getPeso_enviado() != 0) {
            cuenta1.setPeso_enviado(cuentaDetails.getPeso_enviado());
        }
        if (cuentaDetails.getPeso_obtenido() != 0) {
            cuenta1.setPeso_obtenido(cuentaDetails.getPeso_obtenido());
        }
        if (cuentaDetails.getDiferencia_total()!=0) {
            cuenta1.setDiferencia_total(cuentaDetails.getDiferencia_total());
        }
        if (cuentaDetails.getFecha() != null) {
            cuenta1.setFecha(cuentaDetails.getFecha());
        }



        return cuentaRepository.save(cuenta1);
    }
}