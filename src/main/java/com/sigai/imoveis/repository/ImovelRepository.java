package com.sigai.imoveis.repository;

import com.sigai.imoveis.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {
    List<Imovel> findByEnderecoContainingIgnoreCaseAndValorAluguelLessThanEqual(String endereco, Double valorMaximo);
    List<Imovel> findByValorAluguelLessThanEqual(Double valor);
    List<Imovel> findByEnderecoContainingIgnoreCase(String trecho);
}
