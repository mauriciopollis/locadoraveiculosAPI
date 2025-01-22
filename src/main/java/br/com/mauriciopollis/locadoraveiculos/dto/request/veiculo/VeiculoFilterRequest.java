package br.com.mauriciopollis.locadoraveiculos.dto.request.veiculo;

public record VeiculoFilterRequest(int page, int size, String filter) {
}
