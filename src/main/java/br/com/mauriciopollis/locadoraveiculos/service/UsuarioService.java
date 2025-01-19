package br.com.mauriciopollis.locadoraveiculos.service;

import br.com.mauriciopollis.locadoraveiculos.dto.request.CreateUsuarioRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.response.CreateUsuarioResponse;
import br.com.mauriciopollis.locadoraveiculos.dto.response.UsuarioResponse;
import br.com.mauriciopollis.locadoraveiculos.entity.Usuario;
import br.com.mauriciopollis.locadoraveiculos.exception.ValidacaoException;
import br.com.mauriciopollis.locadoraveiculos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<UsuarioResponse> getAllUsers() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponse> usuarioResponses = usuarios
                .stream()
                .map(u -> new UsuarioResponse(u.getId(), u.getNome(), u.getEmail()))
                .toList();
        return usuarioResponses;
    }

    public UsuarioResponse findById(Long id) {
        Optional<Usuario> usuarioDb = usuarioRepository.findById(id);
        if(usuarioDb.isEmpty()) {
            throw new ValidacaoException("Usuário com id " + id + " não existe");
        }
        return new UsuarioResponse(usuarioDb.get().getId(), usuarioDb.get().getNome(), usuarioDb.get().getEmail());
    }
}
