package com.viorel.exchange.repository;

import com.viorel.exchange.domain.DictionarValute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionarValuteRepository extends JpaRepository<DictionarValute, Long> {
    DictionarValute findAllByCodValuta(String codValuta);
}
