package com.sigai.imoveis.exception;

public class FotoNaoEncontradaException extends RuntimeException {
    public FotoNaoEncontradaException(Long id) {
        super("imovel não encontrado" + id);
    }
}
