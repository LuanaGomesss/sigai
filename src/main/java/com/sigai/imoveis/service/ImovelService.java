package com.sigai.imoveis.service;

import com.sigai.imoveis.exception.ImovelNaoEncontradoException;
import com.sigai.imoveis.model.Imovel;
import com.sigai.imoveis.model.dto.request.ImovelRequestDTO;
import com.sigai.imoveis.model.dto.response.ImovelResponseDTO;
import com.sigai.imoveis.repository.ImovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelService {

    private final ImovelRepository imovelRepository;

    public ImovelService(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    public ImovelResponseDTO criar(ImovelRequestDTO dto){
        Imovel salvo = imovelRepository.save(toEntity(dto));
        return toResponseDTO(salvo);
    }

    public List<Imovel> listar(){
        return imovelRepository.findAll();
    }

    public ImovelResponseDTO buscarPorId(Long id){
        Imovel imovel = imovelRepository.findById(id)
                .orElseThrow(() -> new ImovelNaoEncontradoException(id));
        return toResponseDTO(imovel);
    }

    public ImovelResponseDTO atualizar(Long id, ImovelRequestDTO dto){
        Imovel imovel = imovelRepository.findById(id)
                .orElseThrow(() -> new ImovelNaoEncontradoException(id));

        imovel.setDescricao(dto.getDescricao());
        imovel.setEndereco(dto.getEndereco());
        imovel.setValorAluguel(dto.getValorAluguel());

        Imovel atualizado = imovelRepository.save(imovel);
        return toResponseDTO(atualizado);
    }

    public void deletar(Long id){
        Imovel imovel = imovelRepository.findById(id)
                .orElseThrow(() -> new ImovelNaoEncontradoException(id));
        imovelRepository.deleteById(id);
    }

    private Imovel toEntity(ImovelRequestDTO dto){
        return new Imovel(null, dto.getEndereco(), dto.getValorAluguel(),  dto.getDescricao());
    }

    private ImovelResponseDTO toResponseDTO(Imovel imovelEntity){
        return new ImovelResponseDTO(imovelEntity.getId(),imovelEntity.getEndereco(), imovelEntity.getValorAluguel(),imovelEntity.getDescricao());
    }

}
