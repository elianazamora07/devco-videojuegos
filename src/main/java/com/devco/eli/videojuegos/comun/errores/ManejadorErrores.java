package com.devco.eli.videojuegos.comun.errores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ManejadorErrores extends ResponseEntityExceptionHandler {

    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR =
            "Ocurrió un error favor contactar al administrador.";
    private static final ConcurrentHashMap<String, Integer> STATUS_CODE = new ConcurrentHashMap<>();

    public ManejadorErrores() {
        STATUS_CODE.put(BadRequest.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_CODE.put(ForbiddenRequest.class.getSimpleName(), HttpStatus.FORBIDDEN.value());
        STATUS_CODE.put(NotFoundRequest.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiError> handleAllExceptions(Exception exception) {
        ResponseEntity<ApiError> result;

        String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = STATUS_CODE.get(excepcionNombre);
        if (codigo != null) {
            ApiError error = new ApiError(mensaje);
            result = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
            ApiError error = new ApiError(OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
            result = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }
}
