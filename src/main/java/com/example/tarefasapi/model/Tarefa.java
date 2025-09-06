package com.example.tarefasapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
@Getter
@Setter
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "data_entrega", nullable = false)
    @NotNull
    private LocalDate dataEntrega;

    @Column(nullable = false)
    @NotBlank
    private String responsavel;

    // equals & hashCode based on id if needed
}
