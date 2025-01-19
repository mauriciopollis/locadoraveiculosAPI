package br.com.mauriciopollis.locadoraveiculos.controller;

import br.com.mauriciopollis.locadoraveiculos.dto.request.locacao.CreateLocacaoRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.response.locacao.CreateLocacaoResponse;
import br.com.mauriciopollis.locadoraveiculos.service.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locacoes")
@RequiredArgsConstructor
public class LocacaoController {

    private final LocacaoService locacaoService;

    @PostMapping
    public ResponseEntity<CreateLocacaoResponse> create(@RequestBody CreateLocacaoRequest createLocacaoRequest) {
        CreateLocacaoResponse createLocacaoResponse = locacaoService.create(createLocacaoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createLocacaoResponse);
    }
}
