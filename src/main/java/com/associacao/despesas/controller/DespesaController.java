package com.associacao.despesas.controller;

import com.associacao.despesas.model.Despesa;
import com.associacao.despesas.service.DespesaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/despesas")
@RequiredArgsConstructor
@Tag(name = "Despesas", description = "CRUD de despesas da associação")
public class DespesaController {

    private final DespesaService service;

    @PostMapping
    @Operation(summary = "Cadastrar despesa")
    public ResponseEntity<Despesa> cadastrar(@Valid @RequestBody Despesa despesa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(despesa));
    }

    @GetMapping
    @Operation(summary = "Listar todas as despesas")
    public ResponseEntity<List<Despesa>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar despesa pelo identificador")
    public ResponseEntity<Despesa> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar despesa pelo identificador")
    public ResponseEntity<Despesa> atualizar(@PathVariable Long id, @Valid @RequestBody Despesa despesa) {
        return ResponseEntity.ok(service.atualizar(id, despesa));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir despesa pelo identificador")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
