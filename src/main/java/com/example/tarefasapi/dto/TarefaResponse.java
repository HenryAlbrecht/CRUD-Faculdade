package com.example.tarefasapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaResponse {
    private Long id;
    private String nome;
    private LocalDate dataEntrega;
    private String responsavel;
}
