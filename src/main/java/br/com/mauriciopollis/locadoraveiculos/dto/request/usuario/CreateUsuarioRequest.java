package br.com.mauriciopollis.locadoraveiculos.dto.request.usuario;

import br.com.mauriciopollis.locadoraveiculos.entity.enums.TipoUsuarioEnum;

public record CreateUsuarioRequest(String nome,
                                   String email,
                                   String senha,
                                   TipoUsuarioEnum tipo) {
}
