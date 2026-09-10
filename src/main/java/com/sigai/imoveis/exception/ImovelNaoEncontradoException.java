package com.sigai.imoveis.exception;

public class ImovelNaoEncontradoException extends RuntimeException {
    public ImovelNaoEncontradoException(Long id) {
        super("imovél não encontrado " + id);
    }
}
