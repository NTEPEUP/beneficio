package com.beneficio.beneficio.Service;

import com.beneficio.beneficio.model.Pesaje;
import com.beneficio.beneficio.repository.PesajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PesajeService {

    @Autowired
    private PesajeRepository pesajeRepository;

    // Crear un nuevo pesaje
    public Pesaje createPesaje(Pesaje pesaje) {
        return pesajeRepository.save(pesaje);
    }

    // Obtener todos los pesajes
    public List<Pesaje> getAllPesajes() {
        return pesajeRepository.findAll();
    }

    // Obtener un pesaje por su ID
    public Optional<Pesaje> getPesajeById(Long id) {
        return pesajeRepository.findById(id);
    }

    // Actualizar un pesaje existente
    public Pesaje updatePesaje(Long id, Pesaje pesajeDetails) {
        Pesaje pesaje = pesajeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pesaje no encontrado con ID: " + id));
        pesaje.setMedida(pesajeDetails.getMedida());
        pesaje.setPeso_total_actual(pesajeDetails.getPeso_total_actual());
        pesaje.setEstado(pesajeDetails.getEstado());
        pesaje.setUsuario(pesajeDetails.getUsuario());
        pesaje.setFecha(pesajeDetails.getFecha());
        return pesajeRepository.save(pesaje);
    }

    // Eliminar un pesaje por su ID
    public void deletePesaje(Long id) {
        pesajeRepository.deleteById(id);
    }
}