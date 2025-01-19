package br.com.mauriciopollis.locadoraveiculos.service;

import br.com.mauriciopollis.locadoraveiculos.dto.request.usuario.CreateUsuarioRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.request.usuario.UpdateUsuarioRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.response.usuario.CreateUsuarioResponse;
import br.com.mauriciopollis.locadoraveiculos.dto.response.usuario.UsuarioResponse;
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

    public List<UsuarioResponse> findAll() {
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

    public void update(Long id, UpdateUsuarioRequest updateUsuarioRequest) {
        Optional<Usuario> usuarioDb = usuarioRepository.findById(id);
        if(usuarioDb.isEmpty()) {
            throw new ValidacaoException("Usuário de id " + id + " não existe");
        }
        Usuario usuario = usuarioDb.get();
        if(updateUsuarioRequest.nome() != null) usuario.setNome(updateUsuarioRequest.nome());
        if(updateUsuarioRequest.email() != null) usuario.setEmail(updateUsuarioRequest.email());
        if(updateUsuarioRequest.senha() != null) usuario.setSenha(updateUsuarioRequest.senha());
        usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        Optional<Usuario> usuarioDb = usuarioRepository.findById(id);
        if(usuarioDb.isEmpty()) {
            throw new ValidacaoException("Usuário de id " + id + " não existe");
        }
        usuarioRepository.deleteById(id);
    }
}
