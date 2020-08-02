package com.viorel.exchange.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table
public class Numerar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "utilizator", referencedColumnName = "id")
    private Angajati utilizator;
    @ManyToOne
    @JoinColumn(name = "cod_valuta", referencedColumnName = "id")
    private DictionarValute codValuta;
    private double suma;
    @Column(name = "data")
    private LocalDate data;
}
