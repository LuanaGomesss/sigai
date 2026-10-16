package com.sigai.imoveis.service;

import com.sigai.imoveis.exception.FotoNaoEncontradaException;
import com.sigai.imoveis.exception.ImovelNaoEncontradoException;
import com.sigai.imoveis.model.Foto;
import com.sigai.imoveis.model.Imovel;
import com.sigai.imoveis.model.dto.request.FotoRequestDTO;
import com.sigai.imoveis.model.dto.response.FotoResponseDTO;
import com.sigai.imoveis.repository.FotoRepository;
import com.sigai.imoveis.repository.ImovelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FotoService {

    private final FotoRepository fotoRepository;
    private final ImovelRepository imovelRepository;

    public FotoResponseDTO criar(FotoRequestDTO dto){
        Foto salvo = fotoRepository.save(toEntity(dto));
        return toResponseDTO(salvo);
    }

    public List<FotoResponseDTO> listar(){
        List<Foto> fotos = fotoRepository.findAll();
        return fotos.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public FotoResponseDTO buscarPorId(Long id){
        Foto foto = fotoRepository.findById(id)
                .orElseThrow(() -> new FotoNaoEncontradaException(id));
        return toResponseDTO(foto);
    }

    public FotoResponseDTO atualizar(Long id, FotoRequestDTO dto){
        Foto foto = fotoRepository.findById(id)
                .orElseThrow(() -> new FotoNaoEncontradaException(id));

        Foto fotoAtualizada = toEntity(dto);
        fotoAtualizada.setId(id);
        fotoAtualizada = fotoRepository.save(fotoAtualizada);

        return toResponseDTO(fotoAtualizada);
    }

    public void deletar(Long id){
        fotoRepository.findById(id).orElseThrow(() ->  new FotoNaoEncontradaException(id));
        fotoRepository.deleteById(id);
    }

    private Foto toEntity(FotoRequestDTO dto){
        Imovel imovel = imovelRepository.findById(dto.getImovelId()).orElseThrow(() ->
                new ImovelNaoEncontradoException(dto.getImovelId()));

        return new Foto(null, imovel, dto.getUrl(), dto.getLegenda(), dto.getPrincipal());
    }

    private FotoResponseDTO toResponseDTO (Foto fotoEntity){
        Imovel imovel = fotoEntity.getImovel();
        long idimovel = imovel.getId();

        return new FotoResponseDTO(fotoEntity.getId(), idimovel, fotoEntity.getUrl(),fotoEntity.getLegenda(),fotoEntity.getPrincipal());
    }
}
