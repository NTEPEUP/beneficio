package com.beneficio.beneficio.rest;

import com.beneficio.beneficio.Service.TipoPlacaService;
import com.beneficio.beneficio.model.tipoPlaca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipoPlaca")
public class RestTipoPlaca {
    @Autowired
    private TipoPlacaService tipoPlacaService;

    //obtener todos los tipos de placas
    @GetMapping
    public ResponseEntity<List<tipoPlaca>> getAlltipoPlaca(){
        List<tipoPlaca> tipoPlaca = tipoPlacaService.getAlltipoPlaca();
        return ResponseEntity.ok(tipoPlaca);
    }

}

