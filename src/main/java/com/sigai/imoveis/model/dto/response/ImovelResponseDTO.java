package com.sigai.imoveis.model.dto.response;

import lombok.*;

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
}
