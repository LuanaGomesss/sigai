package com.sigai.imoveis.service;

import com.sigai.imoveis.exception.FotoNaoEncontradaException;
import com.sigai.imoveis.model.Foto;
import com.sigai.imoveis.model.dto.request.FotoRequestDTO;
import com.sigai.imoveis.model.dto.response.FotoResponseDTO;
import com.sigai.imoveis.repository.FotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FotoService {

    private final FotoRepository fotoRepository;

    public FotoService(FotoRepository fotoRepository) {
        this.fotoRepository = fotoRepository;
    }

    public FotoResponseDTO criar(FotoRequestDTO dto){
        Foto salvo = fotoRepository.save(toEntity(dto));
        return toResponseDTO(salvo);
    }

    public List<Foto> listar(){
        return fotoRepository.findAll();
    }

    public FotoResponseDTO buscarPorId(Long id){
        Foto foto = fotoRepository.findById(id)
                .orElseThrow(() -> new FotoNaoEncontradaException(id));
        return toResponseDTO(foto);
    }

    public FotoResponseDTO atualizar(Long id, FotoRequestDTO dto){
        Foto foto = fotoRepository.findById(id)
                .orElseThrow(() -> new FotoNaoEncontradaException(id));

        foto.setUrl(dto.getUrl());
        foto.setPrincipal(dto.getPrincipal());
        foto.setLegenda(dto.getLegenda());
        foto.setImovelId(foto.getImovelId());

        Foto atualizado = fotoRepository.save(foto);
        return toResponseDTO(atualizado);
    }

    public void deletar(Long id){
        Foto foto = fotoRepository.findById(id)
                .orElseThrow(() ->  new FotoNaoEncontradaException(id));
        fotoRepository.deleteById(id);
    }

    private Foto toEntity(FotoRequestDTO dto){
        return new Foto(null, dto.getImovelId(), dto.getUrl(), dto.getLegenda(), dto.getPrincipal());
    }

    private FotoResponseDTO toResponseDTO (Foto fotoEntity){
        return new FotoResponseDTO(fotoEntity.getId(),fotoEntity.getImovelId(),fotoEntity.getUrl(),fotoEntity.getLegenda(),fotoEntity.getPrincipal());
    }
}
