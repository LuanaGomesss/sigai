package com.sigai.imoveis.model.dto.request;

import com.sigai.imoveis.model.Imovel;
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

    @NotNull(message = "O ID do imóvel não pode ser nulo ou vazio")
    private Long imovelId;

    @NotBlank(message = "A Url da foto não pode ser nula ou vazia")
    private String url;

    @NotBlank(message = "A legenda não pode ter mais de 200 caracteres")
    @Size(max = 200)
    private String legenda;

    private Boolean principal;
}
