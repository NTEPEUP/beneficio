package com.beneficio.beneficio.Service;

import com.beneficio.beneficio.model.tipoPlaca;
import com.beneficio.beneficio.repository.TipoPlacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPlacaService {
    @Autowired
    private TipoPlacaRepository tipoPlacaRepository;

    public List<tipoPlaca> getAlltipoPlaca() {
        return tipoPlacaRepository.findAll();
    }

}
