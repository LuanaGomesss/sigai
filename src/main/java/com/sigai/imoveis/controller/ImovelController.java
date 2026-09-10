package com.sigai.imoveis.controller;

import com.sigai.imoveis.exception.ImovelNaoEncontradoException;
import com.sigai.imoveis.model.Imovel;
import com.sigai.imoveis.repository.ImovelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    private final ImovelRepository imovelRepository;

    public ImovelController(ImovelRepository imovelRepository){
        this.imovelRepository = imovelRepository;
    }

    @GetMapping
    public List<Imovel> listar(){
        return imovelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Imovel buscarPorId(@PathVariable  Long id){
        return imovelRepository.findById(id)
                .orElseThrow(() -> new ImovelNaoEncontradoException(id));
    }

    @PostMapping()
    public Imovel salvar(@RequestBody Imovel imovel){
        return imovelRepository.save(imovel);
    }

    @PutMapping
    public Imovel atualizar(@PathVariable Long id, @RequestBody Imovel imovel){
        return imovelRepository.save(imovel);
    }
}
