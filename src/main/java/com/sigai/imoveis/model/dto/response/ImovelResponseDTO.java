package com.sigai.imoveis.model.dto.response;

import com.sigai.imoveis.model.Foto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImovelResponseDTO {

    private Long id;
    private String endereco;
    private Double valorAluguel;
    private String descricao;
    private List<Foto> fotos;
}
