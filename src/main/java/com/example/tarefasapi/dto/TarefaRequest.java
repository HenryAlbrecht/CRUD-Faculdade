package com.example.tarefasapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaRequest {
    @NotBlank
    private String nome;

    @NotNull
    private LocalDate dataEntrega;

    @NotBlank
    private String responsavel;
}
