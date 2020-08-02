package com.viorel.exchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "dictionar_valute")
@ToString(exclude = {"numerars", "cursValutars", "schimbValutars"})
public class DictionarValute {
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
