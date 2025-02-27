package com.curso.domains.dtos;

import com.curso.domains.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PacienteDTO {

    private Long idPaciente;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull(message = "O campo custoInternacao nao pode ser nulo")
    @Digits(integer = 15, fraction = 2)
    private BigDecimal custoInternacao;

    @NotNull(message = "O campo Medico é requerido!")
    private int medico;
    private String nomeMedico;

    private int status;

    public PacienteDTO() {
    }

    public PacienteDTO(Paciente paciente) {
        this.idPaciente = paciente.getIdPaciente();
        this.nome = paciente.getNome();
        this.dataNascimento = paciente.getDataNascimento();
        this.custoInternacao = paciente.getCustoInternacao();
        this.status = paciente.getStatus().getId();
        this.medico = paciente.getMedico().getId();
        this.nomeMedico = paciente.getMedico().getNome();

    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    @NotNull(message = "O campo Medico é requerido")
    public int getMedico() {
        return medico;
    }

    public void setMedico(@NotNull(message = "O campo Medico é requerido") int medico) {
        this.medico = medico;
    }

    public String getNomeMedico(){
        return nomeMedico;
    }

    public void setNomeMedico (String nomeMedico ) {
        this.nomeMedico = nomeMedico;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public @NotNull(message = "O campo custoInternacao nao pode ser nulo") @Digits(integer = 15, fraction = 2) BigDecimal getCustoInternacao() {
        return custoInternacao;
    }

    public void setCustoInternacao(@NotNull(message = "O campo custoInternacao nao pode ser nulo") @Digits(integer = 15, fraction = 2) BigDecimal custoInternacao) {
        this.custoInternacao = custoInternacao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode estar vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode estar vazio") String nome) {
        this.nome = nome;
    }


}
