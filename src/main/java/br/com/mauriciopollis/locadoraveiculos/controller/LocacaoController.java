package br.com.mauriciopollis.locadoraveiculos.controller;

import br.com.mauriciopollis.locadoraveiculos.dto.request.locacao.CreateLocacaoRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.request.locacao.UpdateLocacaoRequest;
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

    @GetMapping("/{id}")
    public ResponseEntity<LocacaoResponse> findById(@PathVariable(name = "id") Long id) {
        LocacaoResponse locacaoResponse = locacaoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(locacaoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody UpdateLocacaoRequest updateLocacaoRequest) {
        locacaoService.update(id, updateLocacaoRequest);
        return ResponseEntity.noContent().build();
    }
}
