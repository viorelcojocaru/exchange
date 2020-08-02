package com.viorel.exchange.api;

import com.viorel.exchange.service.SchimbValutarService;
import com.viorel.exchange.transfer.ExchangeDto;
import com.viorel.exchange.transfer.SchimbValutarDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SchimbValutarRestController {
    private final SchimbValutarService schimbValutarService;
    @PostMapping("/exchange")
    public ResponseEntity exchange(@RequestBody ExchangeDto dto) {
        log.info("Request to Exchange Money {}", dto);
        SchimbValutarDto saved = schimbValutarService.exchange(dto);
        if (Objects.isNull(saved)){
            return ResponseEntity.badRequest().body(dto);
        }
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/all/curs-valutar/{codValuta}")
    public ResponseEntity getAllByCodValuta(@PathVariable String codValuta) {
//        List<CursValutarDto> cursValutars = cursValutarService.findByCodValuta(codValuta);
//
//        if(cursValutars != null) {
//            log.info("Cursuri valutare  {}",cursValutars.size());
//            return ResponseEntity.ok(cursValutars);
//        } else {
//            log.info("Curs Valuta : {} NOT FOUND", codValuta);
            return ResponseEntity.notFound().build();
//        }
    }

}
