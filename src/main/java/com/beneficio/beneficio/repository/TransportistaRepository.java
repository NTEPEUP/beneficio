package com.beneficio.beneficio.repository;


import com.beneficio.beneficio.model.Transporte;
import com.beneficio.beneficio.model.Transportista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportistaRepository extends JpaRepository<Transportista, Long> {
    List<Transportista> findByUsuario(Integer usuario);
}

