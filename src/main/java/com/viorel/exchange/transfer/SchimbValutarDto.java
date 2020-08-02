package com.viorel.exchange.transfer;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class SchimbValutarDto {
    private Long id;
    private String codValuta;
    private Double sumaPrimita;
    private Double sumaEliberata;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataTranzactiei;
}
