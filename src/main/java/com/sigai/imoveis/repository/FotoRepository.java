package com.sigai.imoveis.repository;

import com.sigai.imoveis.model.Foto;
import com.sigai.imoveis.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FotoRepository extends JpaRepository<Foto,Long> {
}
