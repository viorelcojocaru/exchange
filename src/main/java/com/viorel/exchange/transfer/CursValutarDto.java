package com.viorel.exchange.transfer;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CursValutarDto {
    private String codValuta;
    private int rata;
    private double curs;
    private String data;
}
