package br.com.mauriciopollis.locadoraveiculos.dto.response.veiculo;

import br.com.mauriciopollis.locadoraveiculos.entity.enums.TipoVeiculoEnum;

import java.math.BigDecimal;

public record VeiculoResponse(Long id,
                              String marca,
                              String modelo,
                              String placa,
                              int ano,
                              BigDecimal diaria,
                              TipoVeiculoEnum tipo) {
}
