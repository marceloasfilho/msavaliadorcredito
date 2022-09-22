package io.github.marceloasfilho.msavaliadorcredito.exceptions;

import lombok.Getter;

public class ErrorComunicacaoMicrosservicesException extends Exception {

    @Getter
    private Integer status;

    public ErrorComunicacaoMicrosservicesException(String message, Integer status) {
        super(message);
        this.status = status;
    }
}
