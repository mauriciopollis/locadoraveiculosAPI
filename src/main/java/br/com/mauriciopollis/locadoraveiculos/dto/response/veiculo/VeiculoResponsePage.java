package br.com.mauriciopollis.locadoraveiculos.dto.response.veiculo;

import java.util.List;

public record VeiculoResponsePage(long total, int pages, List<VeiculoResponse> content) {
}
