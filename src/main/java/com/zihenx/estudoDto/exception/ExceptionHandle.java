package com.zihenx.estudoDto.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandle extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        // Criando lista de erros
        List<ErrorMessage.InfoError> errors = new ArrayList<>();

        // Iterando sobre cada erro e pegando o campo e a mensagem e adicionando a lista de erros
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {

            String field = ((FieldError) error).getField();

            String message = error.getDefaultMessage();

            errors.add(new ErrorMessage.InfoError(field, message));
        }

        var errorMessage = new ErrorMessage(
          status.value(),
                OffsetDateTime.now(),
                "Um ou mais campos estão preenchidos incorretamente, por favor verifique as informações e envie novamente",
                errors
        );

        return handleExceptionInternal(ex, errorMessage, headers, status, request);
    }

    @ExceptionHandler(RegistrationValidationException.class)
    public ResponseEntity<Object> handleRegistrationValidation(RegistrationValidationException ex, WebRequest request) {
        HttpStatus status = HttpStatus.valueOf(HttpStatus.BAD_REQUEST.value());

        var errorMessage = new ErrorMessage(
                status.value(),
                OffsetDateTime.now(),
                ex.getMessage()
        );

        return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), status, request);
    }
}
