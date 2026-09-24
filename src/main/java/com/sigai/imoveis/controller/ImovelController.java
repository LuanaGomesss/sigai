package com.sigai.imoveis.controller;

import com.sigai.imoveis.exception.ImovelNaoEncontradoException;
import com.sigai.imoveis.model.Imovel;
import com.sigai.imoveis.model.dto.request.ImovelRequestDTO;
import com.sigai.imoveis.model.dto.response.ImovelResponseDTO;
import com.sigai.imoveis.repository.ImovelRepository;
import com.sigai.imoveis.service.ImovelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    private final ImovelService imovelService;

    @PostMapping()
    public ResponseEntity<ImovelResponseDTO> criar(@Valid @RequestBody ImovelRequestDTO dto){
       ImovelResponseDTO imovel = imovelService.criar(dto);
       URI uri = URI.create("/imoveis/" + imovel.getId());
       return ResponseEntity.created(uri).body(imovel);
    }

    @GetMapping
    public List<Imovel> listar(){
        return imovelService.listar();
    }

    @GetMapping("/{id}")
    public ImovelResponseDTO buscarPorId(@PathVariable  Long id){
        return imovelService.buscarPorId(id);
    }

    @PutMapping
    public ResponseEntity<ImovelResponseDTO> atualizar(@PathVariable Long id, @RequestBody ImovelRequestDTO dto){
        ImovelResponseDTO atualizado = imovelService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        imovelService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
