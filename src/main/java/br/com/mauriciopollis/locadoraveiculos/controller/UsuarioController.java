package br.com.mauriciopollis.locadoraveiculos.controller;

import br.com.mauriciopollis.locadoraveiculos.dto.request.CreateUsuarioRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.request.UpdateUsuarioRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.response.CreateUsuarioResponse;
import br.com.mauriciopollis.locadoraveiculos.dto.response.UsuarioResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @PostMapping
    public ResponseEntity<CreateUsuarioResponse> create(@RequestBody CreateUsuarioRequest createUsuarioRequest) {
        CreateUsuarioResponse createUsuarioResponse = new CreateUsuarioResponse(10L);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUsuarioResponse);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAll() {
        List<UsuarioResponse> usuarios = new ArrayList<>();
        usuarios.add(new UsuarioResponse(1L, "usuario1", "usuario1@email"));
        usuarios.add(new UsuarioResponse(2L, "usuario2", "usuario2@email"));
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findById() {
        // buscar usuário no banco
        UsuarioResponse usuarioResponse = new UsuarioResponse(99L, "usuario", "usuario@email");
        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UpdateUsuarioRequest updateUsuarioRequest) {
        // fazer update no usuário no banco
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete() {
        // recuperar o usuário do banco
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
