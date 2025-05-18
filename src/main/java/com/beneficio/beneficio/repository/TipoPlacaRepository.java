package com.beneficio.beneficio.repository;

import com.beneficio.beneficio.model.tipoPlaca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPlacaRepository extends JpaRepository<tipoPlaca, Long>{
}
