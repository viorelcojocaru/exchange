package com.viorel.exchange.transfer;

import lombok.Data;

@Data
public class SchimbValutarDto {
    private String codValuta;
    private Double sumaPrimita;
    private Double sumaEliberata;
    private String dataTranzactiei;
}
