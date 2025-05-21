package br.com.fatecararas.tp2suggestionbox.core.config.exceptions;

public class RecursoNaoEncontradoException extends Exception {

    public RecursoNaoEncontradoException(String message) {
        super(message);
    }

    public RecursoNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}
