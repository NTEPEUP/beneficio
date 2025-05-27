package com.beneficio.beneficio.rest;

import com.beneficio.beneficio.Service.MedidaService;
import com.beneficio.beneficio.model.Medida;
import com.beneficio.beneficio.repository.MedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medidas")
public class RestMedida {

    @Autowired
    private MedidaService medidaService;

    // Obtener todas las medidas
    @GetMapping
    public List<Medida> obtenerTodasLasMedidas() {
        return medidaService.obtenerTodasLasMedidas();
    }
}
