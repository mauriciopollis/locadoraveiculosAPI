package br.com.mauriciopollis.locadoraveiculos.controller;

import br.com.mauriciopollis.locadoraveiculos.dto.request.veiculo.CreateVeiculoRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.response.veiculo.CreateVeiculoResponse;
import br.com.mauriciopollis.locadoraveiculos.dto.response.veiculo.VeiculoResponse;
import br.com.mauriciopollis.locadoraveiculos.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<CreateVeiculoResponse> create(@RequestBody CreateVeiculoRequest createVeiculoRequest) {
        CreateVeiculoResponse createVeiculoResponse = veiculoService.create(createVeiculoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createVeiculoResponse);
    }

    public ResponseEntity<List<VeiculoResponse>> findAll() {
        List<VeiculoResponse> veiculoResponses = veiculoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(veiculoResponses);
    }
}
