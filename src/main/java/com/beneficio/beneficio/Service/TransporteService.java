package com.beneficio.beneficio.Service;

import com.beneficio.beneficio.model.Transporte;
import com.beneficio.beneficio.repository.TransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransporteService {
    @Autowired
    private TransporteRepository transporteRepository;


    // Método para listar transportes por usuario
    public List<Transporte> getTransportesPorUsuario(Integer usuario) {
        return transporteRepository.findByUsuario(usuario);
    }

    public Transporte createTransporte(Transporte transporte) {
        return transporteRepository.save(transporte);
    }

    public List<Transporte> getAllTransportes() {
        return transporteRepository.findAll();
    }

    //Listar los transportes en estado Activo
    public List<Transporte> getTransportesActivos() {
        return transporteRepository.findByEstado("Activo");
    }

    public Optional<Transporte> getTransporteById(String placa) {
        return transporteRepository.findById(placa);
    }

    /*
        public Transporte updateTransporte(String placa, Transporte transporteDetails) {
            Transporte transporte = transporteRepository.findById(placa)
                    .orElseThrow(() -> new RuntimeException("Transporte no encontrado con placa: " + placa));

            transporte.setTipo_placa(transporteDetails.getTipo_placa());
            transporte.setMarca(transporteDetails.getMarca());
            transporte.setColor(transporteDetails.getColor());
            transporte.setLinea(transporteDetails.getLinea());
            transporte.setModelo(transporteDetails.getModelo());
            transporte.setEstado(transporteDetails.getEstado());
            transporte.setObservaciones(transporteDetails.getObservaciones());
            transporte.setUsuario(transporteDetails.getUsuario());

            return transporteRepository.save(transporte);
        }*/
    public Transporte updateTransporte(String placa, Transporte transporteDetails) {
        Transporte transporte = transporteRepository.findById(placa)
                .orElseThrow(() -> new RuntimeException("Transporte no encontrado con placa: " + placa));

        // Actualizar solo los campos proporcionados
        if (transporteDetails.getTipo_placa() != 0) {
            transporte.setTipo_placa(transporteDetails.getTipo_placa());
        }
        if (transporteDetails.getMarca() != null) {
            transporte.setMarca(transporteDetails.getMarca());
        }
        if (transporteDetails.getColor() != null) {
            transporte.setColor(transporteDetails.getColor());
        }
        if (transporteDetails.getLinea() != null) {
            transporte.setLinea(transporteDetails.getLinea());
        }
        if (transporteDetails.getModelo() != null) {
            transporte.setModelo(transporteDetails.getModelo());
        }
        if (transporteDetails.getEstado() != null) {
            transporte.setEstado(transporteDetails.getEstado());
        }
        if (transporteDetails.getObservaciones() != null) {
            transporte.setObservaciones(transporteDetails.getObservaciones());
        }
        if (transporteDetails.getUsuario() != null) {
            transporte.setUsuario(transporteDetails.getUsuario());
        }
        return transporteRepository.save(transporte);
    }

    public void deleteTransporte(String placa) {
        transporteRepository.deleteById(placa);
    }
}
