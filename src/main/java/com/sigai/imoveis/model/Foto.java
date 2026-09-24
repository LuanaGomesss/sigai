package com.sigai.imoveis.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Foto {

    private Long id;
    private Long imovelId;
    private String url;
    private String legenda;
    private Boolean principal;
}
