package br.com.mauriciopollis.locadoraveiculos.entity;

import java.time.LocalDate;

public class Locacao {

    private Usuario cliente;
    private Veiculo veiculo;
    private LocalDate dataInicioLocacao;
    private LocalDate dataFinalLocacao;

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDate getDataInicioLocacao() {
        return dataInicioLocacao;
    }

    public void setDataInicioLocacao(LocalDate dataInicioLocacao) {
        this.dataInicioLocacao = dataInicioLocacao;
    }

    public LocalDate getDataFinalLocacao() {
        return dataFinalLocacao;
    }

    public void setDataFinalLocacao(LocalDate dataFinalLocacao) {
        this.dataFinalLocacao = dataFinalLocacao;
    }
}
