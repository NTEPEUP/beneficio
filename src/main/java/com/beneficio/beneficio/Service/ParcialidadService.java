package com.beneficio.beneficio.Service;

import com.beneficio.beneficio.model.Parcialidad;
import com.beneficio.beneficio.repository.ParcialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ParcialidadService {
    @Autowired
    private ParcialidadRepository parcialidadRepository;

    // Guardar una nueva parcialidad
    public Parcialidad guardarParcialidad(Parcialidad parcialidad) {
        return parcialidadRepository.save(parcialidad);
    }

    // Obtener todas las parcialidades
    public List<Parcialidad> obtenerTodasLasParcialidades() {
        return parcialidadRepository.findAll();
    }

    // Obtener una parcialidad por ID
    public Optional<Parcialidad> obtenerParcialidadPorId(Long id) {
        return parcialidadRepository.findById(id);
    }

    // Eliminar una parcialidad por ID
    public void eliminarParcialidad(Long id) {
        parcialidadRepository.deleteById(id);
    }
}
