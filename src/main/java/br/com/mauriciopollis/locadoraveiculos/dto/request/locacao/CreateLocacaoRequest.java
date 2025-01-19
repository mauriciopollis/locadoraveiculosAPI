package br.com.mauriciopollis.locadoraveiculos.dto.request.locacao;

import java.time.LocalDate;

public record CreateLocacaoRequest(Long clienteId,
                                   Long veiculoId,
                                   LocalDate dataInicio,
                                   LocalDate dataFinal) {
}
