package com.viorel.exchange.service;

import com.viorel.exchange.domain.CursValutar;
import com.viorel.exchange.domain.DictionarValute;
import com.viorel.exchange.repository.CursValutarRepository;
import com.viorel.exchange.repository.DictionarValuteRepository;
import com.viorel.exchange.transfer.CursValutarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CursValutarService {
    private final CursValutarRepository cursValutarRepository;
    private final DictionarValuteRepository dictionarValuteRepository;
    private final String DATE_FORMAT= "dd/MM/yyyy";
    public CursValutarDto insertCursValutar(CursValutarDto dto) {
        CursValutar cursValutar = createCursValutar(dto);
        return cursValutarToDto(cursValutarRepository.save(cursValutar));
    }

    private CursValutar createCursValutar(CursValutarDto dto) {
        DictionarValute dv = getDictionarValute(dto.getCodValuta());
        if (Objects.isNull(dv)) {

        }
        CursValutar cursValutar = new CursValutar();
        cursValutar.setCodValuta(dv);
        cursValutar.setCurs(dto.getCurs());
        cursValutar.setRata(dto.getRata());
        cursValutar.setDataCurs(LocalDate.now());
        return cursValutar;
    }

    public List<CursValutarDto> findByCodValuta(String codValuta) {
        List<CursValutar> allByCodValuta = cursValutarRepository.findAllByCodValuta_CodValuta(codValuta);
        List<CursValutarDto> rtv = new ArrayList<>();
        if (Objects.nonNull(allByCodValuta)) {
            allByCodValuta.forEach(one -> rtv.add(cursValutarToDto(one)));
        }
        return rtv;
    }

    public CursValutarDto findByCodValutaNow(String codValuta) {
        return cursValutarToDto(findCursValutarByCodValutaNow(codValuta));
    }
    public CursValutar findCursValutarByCodValutaNow(String codValuta) {
        return cursValutarRepository.findAllByCodValuta_CodValutaAndDataCurs(codValuta, LocalDate.now());
    }

    private CursValutarDto cursValutarToDto(CursValutar cursValutar) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        CursValutarDto dto = new CursValutarDto();
        dto.setCodValuta(cursValutar.getCodValuta().getCodValuta());
        dto.setCurs(cursValutar.getCurs());
        dto.setRata(cursValutar.getRata());
        dto.setData(cursValutar.getDataCurs().format(formatter));
        return dto;
    }

    private DictionarValute getDictionarValute(String codValute) {
        return dictionarValuteRepository.findAllByCodValuta(codValute);
    }

}
