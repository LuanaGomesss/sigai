package com.sigai.imoveis.service;

import com.sigai.imoveis.exception.FotoNaoEncontradaException;
import com.sigai.imoveis.exception.ImovelNaoEncontradoException;
import com.sigai.imoveis.model.Foto;
import com.sigai.imoveis.model.Imovel;
import com.sigai.imoveis.model.dto.request.ImovelRequestDTO;
import com.sigai.imoveis.model.dto.response.ImovelResponseDTO;
import com.sigai.imoveis.repository.FotoRepository;
import com.sigai.imoveis.repository.ImovelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImovelService {

    private final ImovelRepository imovelRepository;

    public ImovelResponseDTO criar(ImovelRequestDTO dto){
        Imovel salvo = imovelRepository.save(toEntity(dto));
        return toResponseDTO(salvo);
    }

    public List<ImovelResponseDTO> listar(){
        List<Imovel> imoveis = imovelRepository.findAll();
        return imoveis.stream()
                .map(this::toResponseDTO)
                .toList();
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
        imovelRepository.findById(id).orElseThrow(() -> new ImovelNaoEncontradoException(id));
        imovelRepository.deleteById(id);
    }

    private Imovel toEntity(ImovelRequestDTO dto){
        return new Imovel(null,dto.getEndereco(), dto.getValorAluguel(),  dto.getDescricao(), dto.getFotos());
    }

    private ImovelResponseDTO toResponseDTO(Imovel imovelEntity){
        return new ImovelResponseDTO(imovelEntity.getId(),imovelEntity.getEndereco(), imovelEntity.getValorAluguel(),imovelEntity.getDescricao(), imovelEntity.getFotos());
    }

    public List<ImovelResponseDTO> listar(String endereco, Double valorMaximo) {
        List<Imovel> imoveis;
        if (endereco != null && valorMaximo != null) {
            imoveis = imovelRepository.findByEnderecoContainingIgnoreCaseAndValorAluguelLessThanEqual(endereco, valorMaximo);
        } else if (endereco != null) {
            imoveis = imovelRepository.findByEnderecoContainingIgnoreCase(endereco);
        } else if (valorMaximo != null) {
            imoveis = imovelRepository.findByValorAluguelLessThanEqual(valorMaximo);
        } else {
            imoveis = imovelRepository.findAll();
        }
        return imoveis.stream().map(this::toResponseDTO).toList();
    }
}
