package com.sigai.imoveis.model.dto.request;

import com.sigai.imoveis.model.Foto;
import com.sigai.imoveis.model.dto.response.FotoResponseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImovelRequestDTO {

    @NotBlank(message = "O endereço não pode ser nulo ou vazio")
    private String endereco;

    @NotNull @Positive
    private Double valorAluguel;

    @Size(max = 500)
    private String descricao;

    private List<Foto> fotos = new ArrayList<>();

}
