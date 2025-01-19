package br.com.mauriciopollis.locadoraveiculos.service;

import br.com.mauriciopollis.locadoraveiculos.dto.request.CreateUsuarioRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.response.CreateUsuarioResponse;
import br.com.mauriciopollis.locadoraveiculos.entity.Usuario;
import br.com.mauriciopollis.locadoraveiculos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public CreateUsuarioResponse save(CreateUsuarioRequest createUsuarioRequest) {
        Usuario usuario = new Usuario();
        usuario.setNome(createUsuarioRequest.nome());
        usuario.setEmail(createUsuarioRequest.email());
        usuario.setSenha(createUsuarioRequest.senha());
        usuario.setTipo(createUsuarioRequest.tipo());
        usuarioRepository.save(usuario);
        return new CreateUsuarioResponse(usuario.getId());
    }
}
