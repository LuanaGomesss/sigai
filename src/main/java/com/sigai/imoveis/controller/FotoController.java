package com.sigai.imoveis.controller;

import com.sigai.imoveis.model.Foto;
import com.sigai.imoveis.model.dto.request.FotoRequestDTO;
import com.sigai.imoveis.model.dto.response.FotoResponseDTO;
import com.sigai.imoveis.service.FotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fotos")
public class FotoController {

    private final FotoService fotoService;

    @PostMapping
    public ResponseEntity<FotoResponseDTO> criar(@Valid @RequestBody FotoRequestDTO dto){
        FotoResponseDTO foto =  fotoService.criar(dto);
        URI uri = URI.create("/fotos/"+foto.getId());
        return ResponseEntity.created(uri).body(foto);
    }

    @GetMapping
    public List<Foto> listar(){
        return fotoService.listar();
    }

    @GetMapping("/{id}")
    public FotoResponseDTO buscar(@PathVariable Long id){
        return fotoService.buscarPorId(id);
    }

    @PutMapping
    public ResponseEntity<FotoResponseDTO> atualizar(@PathVariable Long id, @RequestBody FotoRequestDTO dto){
        FotoResponseDTO atualizado = fotoService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        fotoService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
