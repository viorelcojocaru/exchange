package com.viorel.exchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "dictionar_valute")
public class DictionarValute implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cod_valuta")
    private String codValuta;
    @JsonIgnore
    @OneToMany(mappedBy = "codValuta", fetch = FetchType.LAZY)
    private List<Numerar> numerars = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "codValuta", fetch = FetchType.LAZY)
    private List<CursValutar> cursValutars = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "codValuta", fetch = FetchType.LAZY)
    private List<SchimbValutar> schimbValutars = new ArrayList<>();

}
