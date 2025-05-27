package com.beneficio.beneficio.rest;

import com.beneficio.beneficio.Service.QRService;
import com.beneficio.beneficio.model.Transporte;
import com.beneficio.beneficio.repository.TransporteRepository;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/qr")
public class QRController {

    @Autowired
    private QRService qrService;

    @Autowired
    private TransporteRepository transporteRepository;

    @GetMapping("/generar/transporte")
    public ResponseEntity<byte[]> generarQRTransporte(@RequestParam String placa) {
        Transporte transporte = transporteRepository.findById(placa)
                .orElseThrow(() -> new RuntimeException("Transporte no encontrado"));

        try {
            byte[] qrBytes = qrService.generarQRTransporte(transporte, 300, 300);

            // Configurar los encabezados de la respuesta
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            headers.setContentLength(qrBytes.length);

            return new ResponseEntity<>(qrBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}