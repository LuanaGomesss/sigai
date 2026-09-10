package com.sigai.imoveis.repository;

import com.sigai.imoveis.model.Imovel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ImovelRepository {

    private final List<Imovel> imoveis = new CopyOnWriteArrayList<>();
    private final AtomicLong proximoId = new AtomicLong(1);

    public Optional<Imovel> findById(Long id){
        return imoveis.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public Imovel save (Imovel imovel){
        if(imovel.getId() == null){
            imovel.setId(proximoId.getAndIncrement());
            imoveis.add(imovel);
        }
        else {
            deleteById(imovel.getId());
            imoveis.add(imovel);
        }
        return imovel;
    }

    public List<Imovel> findAll(){
        return imoveis;
    }

    public void deleteById(Long id){
        imoveis.removeIf(i -> i.getId().equals(id));
    }




}
