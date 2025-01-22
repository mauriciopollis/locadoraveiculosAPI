package br.com.mauriciopollis.locadoraveiculos.dto.response.veiculo;

import java.util.List;

public record VeiculoResponsePage(long totalPages, int size, List<VeiculoResponse> content) {
}
