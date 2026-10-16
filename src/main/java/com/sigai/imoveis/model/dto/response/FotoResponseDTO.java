package com.sigai.imoveis.model.dto.response;

import com.sigai.imoveis.model.Imovel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FotoResponseDTO {

    private Long id;
    private Long imovelId;
    private String url;
    private String legenda;
    private Boolean principal;
}
