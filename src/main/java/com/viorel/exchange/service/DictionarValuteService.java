package com.viorel.exchange.service;

import com.viorel.exchange.domain.DictionarValute;
import com.viorel.exchange.repository.DictionarValuteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DictionarValuteService {
    private final DictionarValuteRepository repository;

    public DictionarValute findByCodValuta(String codValuta) {
        return repository.findAllByCodValuta(codValuta);
    }

}
