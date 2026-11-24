package com.associacao.despesas.exception;

public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(Long id) {
        super("Despesa não encontrada com o identificador " + id);
    }
}
