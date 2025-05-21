package br.com.fatecararas.tp2suggestionbox.core.config.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ApiError recursoNaoEncontradoException(RecursoNaoEncontradoException rne,
                                                  HttpServletRequest req) {
        return new ApiError(rne, req.getRequestURI());
    }
}
