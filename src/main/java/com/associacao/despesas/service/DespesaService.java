package com.associacao.despesas.service;

import com.associacao.despesas.exception.RecursoNaoEncontradoException;
import com.associacao.despesas.model.Despesa;
import com.associacao.despesas.repository.DespesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DespesaService {

    private final DespesaRepository repository;

    @Transactional
    public Despesa cadastrar(Despesa despesa) {
        despesa.setId(null); // garante que o identificador é gerado pelo banco
        return repository.save(despesa);
    }

    @Transactional(readOnly = true)
    public List<Despesa> listar() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Despesa buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(id));
    }

    @Transactional
    public Despesa atualizar(Long id, Despesa dados) {
        Despesa existente = buscarPorId(id);
        existente.setDescricao(dados.getDescricao());
        existente.setCategoria(dados.getCategoria());
        existente.setValor(dados.getValor());
        existente.setDataDespesa(dados.getDataDespesa());
        return repository.save(existente);
    }

    @Transactional
    public void excluir(Long id) {
        Despesa existente = buscarPorId(id);
        repository.delete(existente);
    }
}
