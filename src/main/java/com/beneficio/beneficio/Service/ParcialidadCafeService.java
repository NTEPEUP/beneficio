package com.beneficio.beneficio.Service;

import com.beneficio.beneficio.model.ParcialidadCafe;
import com.beneficio.beneficio.repository.ParcialidadCafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParcialidadCafeService {

    @Autowired
    private ParcialidadCafeRepository parcialidadCafeRepository;

    // Obtener todas las parcialidades de café
    public List<ParcialidadCafe> obtenerTodasLasParcialidades() {
        return parcialidadCafeRepository.findAll();
    }

    // Obtener una parcialidad de café por ID
    public Optional<ParcialidadCafe> obtenerParcialidadPorId(Long id) {
        return parcialidadCafeRepository.findById(id);
    }

    // Guardar una nueva parcialidad de café
    public ParcialidadCafe guardarParcialidad(ParcialidadCafe parcialidadCafe) {
        return parcialidadCafeRepository.save(parcialidadCafe);
    }

    // Actualizar una parcialidad de café existente
    public ParcialidadCafe actualizarParcialidad(Long id, ParcialidadCafe parcialidadActualizada) {
        return parcialidadCafeRepository.findById(id).map(parcialidad -> {
            parcialidad.setCuenta(parcialidadActualizada.getCuenta());
            parcialidad.setId_transporte(parcialidadActualizada.getId_transporte());
            parcialidad.setFecha_recepcion_parcialidad(parcialidadActualizada.getFecha_recepcion_parcialidad());
            parcialidad.setPeso_enviado(parcialidadActualizada.getPeso_enviado());
            parcialidad.setPeso_bascula(parcialidadActualizada.getPeso_bascula());
            parcialidad.setDiferencia_peso(parcialidadActualizada.getDiferencia_peso());
            parcialidad.setFecha_peso_bascula(parcialidadActualizada.getFecha_peso_bascula());
            parcialidad.setUsuario(parcialidadActualizada.getUsuario());
            return parcialidadCafeRepository.save(parcialidad);
        }).orElseThrow(() -> new RuntimeException("Parcialidad no encontrada con ID: " + id));
    }

    // Eliminar una parcialidad de café por ID
    public void eliminarParcialidad(Long id) {
        parcialidadCafeRepository.deleteById(id);
    }


    // Obtener parcialidades por id_cuenta
    public List<ParcialidadCafe> obtenerParcialidadesPorIdCuenta(Long cuenta) {
        return parcialidadCafeRepository.findByCuenta_Cuenta(cuenta);
    }
}