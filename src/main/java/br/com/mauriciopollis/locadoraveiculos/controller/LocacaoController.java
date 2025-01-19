package br.com.mauriciopollis.locadoraveiculos.controller;

import br.com.mauriciopollis.locadoraveiculos.dto.request.locacao.CreateLocacaoRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.response.locacao.CreateLocacaoResponse;
import br.com.mauriciopollis.locadoraveiculos.dto.response.locacao.LocacaoResponse;
import br.com.mauriciopollis.locadoraveiculos.service.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<LocacaoResponse>> findAll() {
        List<LocacaoResponse> locacaoResponses = locacaoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(locacaoResponses);
    }
}
