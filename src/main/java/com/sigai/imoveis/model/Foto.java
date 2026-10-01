package com.sigai.imoveis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fotos")
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imovel_id")
    private Long imovelId;

    @Column(name = "url")
    private String url;

    @Column(name = "legenda")
    private String legenda;

    @Column(name = "principal")
    private Boolean principal;
}
