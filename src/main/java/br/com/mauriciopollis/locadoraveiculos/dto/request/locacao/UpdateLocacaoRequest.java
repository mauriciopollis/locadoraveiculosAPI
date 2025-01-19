package br.com.mauriciopollis.locadoraveiculos.dto.request.locacao;

import br.com.mauriciopollis.locadoraveiculos.entity.enums.StatusLocacaoEnum;

public record UpdateLocacaoRequest(StatusLocacaoEnum status) {
}
