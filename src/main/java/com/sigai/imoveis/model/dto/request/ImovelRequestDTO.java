package com.sigai.imoveis.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImovelRequestDTO {

    @NotBlank(message = "endereço é obrigatório")
    private String endereco;

    @NotNull @Positive
    private Double valorAluguel;

    @Size(max = 500)
    private String descricao;

}
