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

    public Transporte createTransporte(Transporte transporte) {
        return transporteRepository.save(transporte);
    }

    public List<Transporte> getAllTransportes() {
        return transporteRepository.findAll();
    }

    public Optional<Transporte> getTransporteById(String placa) {
        return transporteRepository.findById(placa);
    }

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
    }

    public void deleteTransporte(String placa) {
        transporteRepository.deleteById(placa);
    }
}
