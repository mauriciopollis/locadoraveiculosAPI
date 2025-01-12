package br.com.mauriciopollis.locadoraveiculos.controller;

import br.com.mauriciopollis.locadoraveiculos.dto.request.CreateUsuarioRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.response.CreateUsuarioResponse;
import br.com.mauriciopollis.locadoraveiculos.entity.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @PostMapping
    public ResponseEntity<CreateUsuarioResponse> create(@RequestBody CreateUsuarioRequest createUsuarioRequest) {
        CreateUsuarioResponse createUsuarioResponse = new CreateUsuarioResponse(10L);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUsuarioResponse);
    }
}
