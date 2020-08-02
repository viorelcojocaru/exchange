package com.viorel.exchange.service;

import com.viorel.exchange.domain.CursValutar;
import com.viorel.exchange.domain.DictionarValute;
import com.viorel.exchange.domain.SchimbValutar;
import com.viorel.exchange.repository.DictionarValuteRepository;
import com.viorel.exchange.repository.SchimbValutarRepository;
import com.viorel.exchange.transfer.ExchangeDto;
import com.viorel.exchange.transfer.SchimbValutarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SchimbValutarService {
    private final SchimbValutarRepository schimbValutarRepository;
    private final DictionarValuteRepository dictionarValuteRepository;
    private final CursValutarService cursValutarService;

    private final String DATE_FORMAT= "dd/MM/yyyy HH:mm:ss";
// use in case first was added CursValutar for today
    public SchimbValutarDto exchange(String codValutar, Double sumaPrimita){
        DictionarValute dv = getDictionarValute(codValutar);
        if (Objects.nonNull(dv)){
            CursValutar cursValuta = cursValutarService.findCursValutarByCodValutaNow(codValutar);
            if (Objects.nonNull(cursValuta)){
                SchimbValutar sv =new SchimbValutar();
                sv.setCodValuta(dv);
                sv.setDataTranzactiei(LocalDateTime.now());
                sv.setSumaPrimita(sumaPrimita);
                sv.setSumaEliberata(sumaPrimita*cursValuta.getCurs());
                return schimbValutarToDto(schimbValutarRepository.save(sv));
            }
        }

        return null;
    }

    public SchimbValutarDto exchange(ExchangeDto dto){
        DictionarValute dv = getDictionarValute(dto.getCodValuta());
        if (Objects.isNull(dv)){

        }
        SchimbValutar sv =new SchimbValutar();
        sv.setCodValuta(dv);
        sv.setDataTranzactiei(LocalDateTime.now());
        sv.setSumaPrimita(dto.getSumaPrimita());
        sv.setSumaEliberata(dto.getSumaEliberata());
        return schimbValutarToDto(schimbValutarRepository.save(sv));
    }

    private DictionarValute getDictionarValute(String codValute) {
        return dictionarValuteRepository.findAllByCodValuta(codValute);
    }

    private SchimbValutarDto schimbValutarToDto(SchimbValutar schimbValutar){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        SchimbValutarDto rtv =new SchimbValutarDto();
        rtv.setCodValuta(schimbValutar.getCodValuta().getCodValuta());
        rtv.setSumaEliberata(schimbValutar.getSumaEliberata());
        rtv.setSumaPrimita(schimbValutar.getSumaPrimita());
        rtv.setDataTranzactiei(schimbValutar.getDataTranzactiei().format(formatter));
      return rtv;
    }
}
