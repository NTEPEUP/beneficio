package com.beneficio.beneficio.Service;

import com.beneficio.beneficio.model.Medida;
import com.beneficio.beneficio.repository.MedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedidaService {

    @Autowired
    private MedidaRepository medidaRepository;

    // Obtener todas las medidas
    public List<Medida> obtenerTodasLasMedidas() {
        return medidaRepository.findAll();
    }
}
