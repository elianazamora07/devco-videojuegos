package com.devco.eli.videojuegos.common.exceptions;

import com.devco.eli.videojuegos.common.exceptions.exception.BadRequest;
import com.devco.eli.videojuegos.common.exceptions.exception.ForbiddenRequest;
import com.devco.eli.videojuegos.common.exceptions.exception.NotFoundRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR =
            "Ocurrió un error favor contactar al administrador.";
    private static final ConcurrentHashMap<String, Integer> STATUS_CODE = new ConcurrentHashMap<>();

    public HandlerException() {
        STATUS_CODE.put(BadRequest.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_CODE.put(ForbiddenRequest.class.getSimpleName(), HttpStatus.FORBIDDEN.value());
        STATUS_CODE.put(NotFoundRequest.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiException> handleAllExceptions(Exception exception) {
        ResponseEntity<ApiException> result;

        String exceptionName = exception.getClass().getSimpleName();
        String message = exception.getMessage();
        Integer code = STATUS_CODE.get(exceptionName);
        if (code != null) {
            ApiException error = new ApiException(message);
            result = new ResponseEntity<>(error, HttpStatus.valueOf(code));
        } else {
            ApiException error = new ApiException(OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
            result = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }
}
