package com.viorel.exchange.transfer;

import lombok.Data;

@Data
public class ExchangeDto {
    private String codValuta;
    private Double cursSchimb;
    private Double sumaPrimita;
    private Double sumaEliberata;
}
