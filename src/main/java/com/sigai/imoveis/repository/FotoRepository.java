package com.sigai.imoveis.repository;

import com.sigai.imoveis.model.Foto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FotoRepository {

    private final AtomicLong proximoId = new AtomicLong(1);
    private final List<Foto> fotos = new CopyOnWriteArrayList<>();

    public Optional<Foto> findById(Long id){
        return fotos.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public Foto save (Foto foto){
        if(foto.getId() == null){
            foto.setId(proximoId.getAndIncrement());
            fotos.add(foto);
        }
        else {
            deleteById(foto.getId());
            fotos.add(foto);
        }
        return foto;
    }

    public List<Foto> findAll(){
        return fotos;
    }

    public void deleteById(Long id){
        fotos.removeIf(i -> i.getId().equals(id));
    }
}
