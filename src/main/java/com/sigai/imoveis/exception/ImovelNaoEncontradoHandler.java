package com.sigai.imoveis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ImovelNaoEncontradoHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ImovelNaoEncontradoException.class)
    public String handleException(ImovelNaoEncontradoException e){
        return e.getMessage();
    }

}
