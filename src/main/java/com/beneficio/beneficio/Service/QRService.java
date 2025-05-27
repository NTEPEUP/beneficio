package com.beneficio.beneficio.Service;

import com.beneficio.beneficio.model.Transporte;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class QRService {

    public byte[] generarQRTransporte(Transporte transporte, int ancho, int alto) throws WriterException, IOException {
        if (transporte == null) {
            throw new IllegalArgumentException("El objeto Transporte no puede ser nulo");
        }

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String datos = String.format("Placa: %s, Tipo Placa: %d, Marca: %s, Color: %s, Línea: %s, Modelo: %s, Estado: %s, Observaciones: %s",
                transporte.getPlaca() != null ? transporte.getPlaca() : "N/A",
                transporte.getTipo_placa(), // No se verifica null porque es un primitivo
                transporte.getMarca() != null ? transporte.getMarca() : "N/A",
                transporte.getColor() != null ? transporte.getColor() : "N/A",
                transporte.getLinea() != null ? transporte.getLinea() : "N/A",
                transporte.getModelo() != null ? transporte.getModelo() : "N/A",
                transporte.getEstado() != null ? transporte.getEstado() : "N/A",
                transporte.getObservaciones() != null ? transporte.getObservaciones() : "N/A");

        BitMatrix bitMatrix = qrCodeWriter.encode(datos, BarcodeFormat.QR_CODE, ancho, alto);

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
    }
}