package com.sigai.imoveis.model;

import com.sigai.imoveis.model.dto.response.FotoResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "imoveis")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "valorAlugel")
    private Double valorAluguel;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "imovel")
    private List<Foto> fotos = new ArrayList<>();
}
