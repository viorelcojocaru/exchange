package com.viorel.exchange.repository;

import com.viorel.exchange.domain.CursValutar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface CursValutarRepository extends JpaRepository<CursValutar, Long> {
    List<CursValutar> findAllByCodValuta_CodValuta(String codValuta);
    CursValutar findAllByCodValuta_CodValutaAndDataCurs(String codValuta, LocalDate data);

}
