package com.sigai.imoveis.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FotoRequestDTO {

    @NotNull(message = "Id do imóvel é obrigatório")
    private Long imovelId;

    @NotBlank(message = "Url é obrigatória")
    private String url;

    @NotBlank(message = "Legenda é obrigatória")
    @Size(max = 200)
    private String legenda;

    private Boolean principal;
}
