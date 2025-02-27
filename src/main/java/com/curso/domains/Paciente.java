package com.curso.domains;


import com.curso.domains.dtos.PacienteDTO;
import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente")
    private Long idPaciente;

    @NotNull
    @NotBlank
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull
    @Digits(integer = 15, fraction = 2)
    private BigDecimal custoInternacao;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico medico;


    public Paciente() {

    }

    public Paciente(Long idPaciente, String nome, LocalDate dataNascimento, BigDecimal custoInternacao, Status status, Medico medico) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.custoInternacao = custoInternacao;
        this.status = status;
        this.medico = medico;
    }

    public Paciente(PacienteDTO dto) {
        this.idPaciente = dto.getIdPaciente();
        this.nome = dto.getNome();
        this.dataNascimento = dto.getDataNascimento();
        this.custoInternacao = dto.getCustoInternacao();
        this.status = Status.toEnum(dto.getStatus());
        this.medico = new Medico();
        this.medico.setId(dto.getMedico());
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }


    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotNull @Digits(integer = 15, fraction = 2) BigDecimal getCustoInternacao() {
        return custoInternacao;
    }

    public void setCustoInternacao(@NotNull @Digits(integer = 15, fraction = 2) BigDecimal custoInternacao) {
        this.custoInternacao = custoInternacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }


}
