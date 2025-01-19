package br.com.mauriciopollis.locadoraveiculos.controller;

import br.com.mauriciopollis.locadoraveiculos.dto.request.usuario.CreateUsuarioRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.request.usuario.UpdateUsuarioRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.response.usuario.CreateUsuarioResponse;
import br.com.mauriciopollis.locadoraveiculos.dto.response.usuario.UsuarioResponse;
import br.com.mauriciopollis.locadoraveiculos.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<CreateUsuarioResponse> create(@RequestBody CreateUsuarioRequest createUsuarioRequest) {
        CreateUsuarioResponse createUsuarioResponse = usuarioService.save(createUsuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUsuarioResponse);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAll() {
        List<UsuarioResponse> usuarioResponses = usuarioService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable(name = "id") Long id) {
        UsuarioResponse usuarioResponse = usuarioService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody UpdateUsuarioRequest updateUsuarioRequest) {
        usuarioService.update(id, updateUsuarioRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
