package com.beneficio.beneficio.Service;

import com.beneficio.beneficio.model.Transportista;
import com.beneficio.beneficio.repository.TransportistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class TransportistaService {

    @Autowired
    private TransportistaRepository transportistaRepository;

    // Crear un nuevo transportista
    public Transportista createTransportista(Transportista transportista) {
        return transportistaRepository.save(transportista);
    }

    // Obtener todos los transportistas
    public List<Transportista> getAllTransportistas() {
        return transportistaRepository.findAll();
    }

    // Obtener un transportista por su CUI
    public Optional<Transportista> getTransportistaById(long cui) {
        return transportistaRepository.findById(cui);
    }

    // Actualizar un transportista existente
    /*public Transportista updateTransportista(long cui, Transportista transportistaDetails) {
        return transportistaRepository.findById(cui).map(transportista -> {
            transportista.setNombre(transportistaDetails.getNombre());
            transportista.setFechaNacimiento(transportistaDetails.getFechaNacimiento());
            transportista.setTipoLicencia(transportistaDetails.getTipoLicencia());
            transportista.setFechaVencimientoLicencia(transportistaDetails.getFechaVencimientoLicencia());
            transportista.setEstado(transportistaDetails.getEstado());
            transportista.setObservaciones(transportistaDetails.getObservaciones());
            transportista.setUsuario(transportistaDetails.getUsuario());
            return transportistaRepository.save(transportista);
        }).orElseThrow(() -> new RuntimeException("Transportista no encontrado con CUI: " + cui));
    }*/

    public Transportista updateTransportista(long cui, Transportista transportistaDetails) {
        return transportistaRepository.findById(cui).map(transportista -> {
            if (transportistaDetails.getNombre() != null) {
                transportista.setNombre(transportistaDetails.getNombre());
            }
            if (transportistaDetails.getFechaNacimiento() != null) {
                transportista.setFechaNacimiento(transportistaDetails.getFechaNacimiento());
            }
            if (transportistaDetails.getTipoLicencia() != null) {
                transportista.setTipoLicencia(transportistaDetails.getTipoLicencia());
            }
            if (transportistaDetails.getFechaVencimientoLicencia() != null) {
                transportista.setFechaVencimientoLicencia(transportistaDetails.getFechaVencimientoLicencia());
            }
            if (transportistaDetails.getEstado() != null) {
                transportista.setEstado(transportistaDetails.getEstado());
            }
            if (transportistaDetails.getObservaciones() != null) {
                transportista.setObservaciones(transportistaDetails.getObservaciones());
            }
            if (transportistaDetails.getUsuario() != null) {
                transportista.setUsuario(transportistaDetails.getUsuario());
            }
            return transportistaRepository.save(transportista);
        }).orElseThrow(() -> new RuntimeException("Transportista no encontrado con CUI: " + cui));
    }

    // Eliminar un transportista por su CUI
    public void deleteTransportista(long cui) {
        transportistaRepository.deleteById(cui);
    }


}
