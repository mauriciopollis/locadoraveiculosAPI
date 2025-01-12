package br.com.mauriciopollis.locadoraveiculos.dto.request;

public record CreateUsuarioRequest(String nome,
                                   String email,
                                   String senha) {
}
