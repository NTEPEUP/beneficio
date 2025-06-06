package com.beneficio.beneficio.Service;

import com.beneficio.beneficio.model.Cuenta;
import com.beneficio.beneficio.model.Pesaje;
import com.beneficio.beneficio.repository.CuentaRepository;
import com.beneficio.beneficio.repository.PesajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PesajeService {

    @Autowired
    private PesajeRepository pesajeRepository;
    private final CuentaRepository cuentaRepository;

    @Autowired
    public PesajeService(PesajeRepository pesajeRepository, CuentaRepository cuentaRepository) {
        this.pesajeRepository = pesajeRepository;
        this.cuentaRepository = cuentaRepository;
    }

    public Pesaje createPesaje(Pesaje pesaje) {
        // Guardar el pesaje
        Pesaje nuevoPesaje = pesajeRepository.save(pesaje);

        // Crear una nueva cuenta asociada al pesaje
        Cuenta nuevaCuenta = new Cuenta();
        nuevaCuenta.setId_pesaje(nuevoPesaje.getId()); // Asignar el id del pesaje
        nuevaCuenta.setPeso_enviado(nuevoPesaje.getPeso_total_actual()); // Asignar peso_total_actual como peso_enviado
        nuevaCuenta.setPeso_obtenido(0.0f); // Inicializa peso_obtenido
        nuevaCuenta.setFecha(nuevoPesaje.getFecha().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()); // Convertir Date a LocalDate
        cuentaRepository.save(nuevaCuenta);

        return nuevoPesaje;
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