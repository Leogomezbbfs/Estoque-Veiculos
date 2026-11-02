package com.gestaoestoque.estoque_veiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> tratarRuntimeException(RuntimeException ex) {
        HttpStatus status = ex.getMessage().contains("não encontrad") 
                ? HttpStatus.NOT_FOUND 
                : HttpStatus.BAD_REQUEST;

        ErrorResponse erro = new ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage()
        );

        return ResponseEntity.status(status).body(erro);
    }
}