package com.beneficio.beneficio.Service;

import com.beneficio.beneficio.model.Agricultor;
import com.beneficio.beneficio.repository.AgricultorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgricultorService {
    private final AgricultorRepository agricultorRepository;

    @Autowired
    public AgricultorService(AgricultorRepository agricultorRepository) {
        this.agricultorRepository = agricultorRepository;
    }

    public Optional<Agricultor> getAgricultorById(Long id) {
        return agricultorRepository.findById(id);
    }

    public Agricultor saveAgricultor(Agricultor agricultor) {
        return agricultorRepository.save(agricultor);
    }

    public void deleteAgricultorById(Long id) {
        agricultorRepository.deleteById(id);
    }
}
