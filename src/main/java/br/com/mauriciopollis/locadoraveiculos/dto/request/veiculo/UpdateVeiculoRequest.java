package br.com.mauriciopollis.locadoraveiculos.dto.request.veiculo;

import br.com.mauriciopollis.locadoraveiculos.entity.enums.TipoVeiculoEnum;

import java.math.BigDecimal;

public record UpdateVeiculoRequest(String placa, BigDecimal diaria) {
}
