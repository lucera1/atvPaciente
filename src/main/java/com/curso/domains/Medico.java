package com.curso.domains;

import com.curso.domains.dtos.MedicoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_medico")
    private Integer id;

    @NotNull @NotBlank
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataContratacao;

    @NotNull
    @Digits(integer = 15, fraction = 2)
    private BigDecimal salario;

    @JsonIgnore
    @OneToMany(mappedBy = "medico")
    private List<Paciente> pacientes = new ArrayList<>();


    public Medico() {
    }

    public Medico(Integer id, String nome, LocalDate dataContratacao, BigDecimal salario) {
        this.id = id;
        this.nome = nome;
        this.dataContratacao = dataContratacao;
        this.salario = salario;
    }

    public Medico(MedicoDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.dataContratacao = dto.getDataContratacao();
        this.salario = dto.getSalario();
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public @NotNull @Digits(integer = 15, fraction = 2) BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(@NotNull @Digits(integer = 15, fraction = 2) BigDecimal salario) {
        this.salario = salario;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

}
