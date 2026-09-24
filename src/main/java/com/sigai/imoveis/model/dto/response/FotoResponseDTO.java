package com.sigai.imoveis.model.dto.response;

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
