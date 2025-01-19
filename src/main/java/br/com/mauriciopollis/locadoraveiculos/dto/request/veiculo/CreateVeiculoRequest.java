package br.com.mauriciopollis.locadoraveiculos.dto.request.veiculo;

import br.com.mauriciopollis.locadoraveiculos.entity.enums.TipoVeiculoEnum;

import java.math.BigDecimal;

public record CreateVeiculoRequest(String placa,
                                   String marca,
                                   String modelo,
                                   int ano,
                                   TipoVeiculoEnum tipo,
                                   BigDecimal diaria) {
}
