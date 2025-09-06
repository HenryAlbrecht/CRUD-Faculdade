package com.example.tarefasapi.controller;

import com.example.tarefasapi.dto.TarefaRequest;
import com.example.tarefasapi.dto.TarefaResponse;
import com.example.tarefasapi.model.Tarefa;
import com.example.tarefasapi.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaResponse> criar(@Validated @RequestBody TarefaRequest req) {
        Tarefa created = service.criar(req);
        TarefaResponse resp = toResponse(created);
        return ResponseEntity.created(URI.create("/api/tarefas/" + resp.getId())).body(resp);
    }

    @GetMapping
    public List<TarefaResponse> listar() {
        return service.listarTodos().stream().map(this::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TarefaResponse buscar(@PathVariable Long id) {
        return toResponse(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public TarefaResponse atualizar(@PathVariable Long id, @Validated @RequestBody TarefaRequest req) {
        return toResponse(service.atualizar(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    private TarefaResponse toResponse(Tarefa t) {
        return new TarefaResponse(t.getId(), t.getNome(), t.getDataEntrega(), t.getResponsavel());
    }
}
