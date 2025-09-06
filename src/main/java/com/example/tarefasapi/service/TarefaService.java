package com.example.tarefasapi.service;

import com.example.tarefasapi.dto.TarefaRequest;
import com.example.tarefasapi.model.Tarefa;
import com.example.tarefasapi.repository.TarefaRepository;
import com.example.tarefasapi.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository repository;

    @Transactional(readOnly = true)
    public List<Tarefa> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Tarefa buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com id: " + id));
    }

    @Transactional
    public Tarefa criar(TarefaRequest req) {
        Tarefa t = new Tarefa();
        t.setNome(req.getNome());
        t.setDataEntrega(req.getDataEntrega());
        t.setResponsavel(req.getResponsavel());
        return repository.save(t);
    }

    @Transactional
    public Tarefa atualizar(Long id, TarefaRequest req) {
        Tarefa existing = buscarPorId(id);
        existing.setNome(req.getNome());
        existing.setDataEntrega(req.getDataEntrega());
        existing.setResponsavel(req.getResponsavel());
        return repository.save(existing);
    }

    @Transactional
    public void deletar(Long id) {
        Tarefa existing = buscarPorId(id);
        repository.delete(existing);
    }
}
