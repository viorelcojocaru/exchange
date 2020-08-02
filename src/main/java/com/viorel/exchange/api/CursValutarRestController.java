package com.viorel.exchange.api;

import com.viorel.exchange.domain.CursValutar;
import com.viorel.exchange.service.CursValutarService;
import com.viorel.exchange.transfer.CursValutarDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CursValutarRestController {
    private final CursValutarService cursValutarService;
    @PostMapping("/add-curs-valutar")
    public ResponseEntity addCursValutar(@RequestBody CursValutarDto valutarDto) {
        log.info("Request to insert CursValutar {}", valutarDto);
        CursValutarDto saved = cursValutarService.insertCursValutar(valutarDto);
        if (Objects.isNull(saved)){
            return ResponseEntity.badRequest().body(valutarDto);
        }
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/all/curs-valutar/{codValuta}")
    public ResponseEntity getAllByCodValuta(@PathVariable String codValuta) {
        List<CursValutarDto> cursValutars = cursValutarService.findByCodValuta(codValuta);

        if(cursValutars != null) {
            log.info("Cursuri valutare  {}",cursValutars.size());
            return ResponseEntity.ok(cursValutars);
        } else {
            log.info("Curs Valuta : {} NOT FOUND", codValuta);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/curs-valutar/{codValuta}")
    public ResponseEntity getByCodValutaNow(@PathVariable String codValuta) {
        CursValutarDto cursValutar = cursValutarService.findByCodValutaNow(codValuta);

        if(cursValutar != null) {
            log.info("Curs valutar at {} :  {}", LocalDate.now(), cursValutar.toString());
            return ResponseEntity.ok(cursValutar);
        } else {
            log.info("Curs Valuta : {} NOT FOUND", codValuta);
            return ResponseEntity.notFound().build();
        }
    }


}
