package com.viorel.exchange.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "curs_valutar")
@ToString(exclude = "codValuta")
@EqualsAndHashCode(exclude = "codValuta")
public class CursValutar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cod_valuta", referencedColumnName = "id")
    private DictionarValute codValuta;
    private int rata;
    private double curs;
    @Column(name = "data_curs")
    private LocalDate dataCurs;
}
