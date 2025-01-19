package br.com.mauriciopollis.locadoraveiculos.dto.response.locacao;

import br.com.mauriciopollis.locadoraveiculos.entity.Usuario;
import br.com.mauriciopollis.locadoraveiculos.entity.Veiculo;
import br.com.mauriciopollis.locadoraveiculos.entity.enums.StatusLocacaoEnum;

import java.time.LocalDate;

public record LocacaoResponse(Long id,
                              Usuario cliente,
                              Veiculo veiculo,
                              LocalDate dataInicio,
                              LocalDate dataFinal,
                              StatusLocacaoEnum status) {
}
