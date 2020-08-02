package com.viorel.exchange.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "schimb_valutar")
public class SchimbValutar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cod_valuta", referencedColumnName = "id")
    private DictionarValute codValuta;
    @Column(name = "suma_primita")
    private Double sumaPrimita;
    @Column(name = "suma_eliberata")
    private Double sumaEliberata;
    @Column(name = "data_tranzactiei")
    private LocalDateTime dataTranzactiei;
}
