package com.viorel.exchange.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "angajati")
public class Angajati {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nume;

    @OneToMany(mappedBy = "utilizator", fetch = FetchType.LAZY)
    private List<Numerar> numerars = new ArrayList<>();

}
