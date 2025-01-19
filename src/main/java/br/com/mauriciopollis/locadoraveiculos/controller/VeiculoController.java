package br.com.mauriciopollis.locadoraveiculos.controller;

import br.com.mauriciopollis.locadoraveiculos.dto.request.veiculo.CreateVeiculoRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.request.veiculo.UpdateVeiculoRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.response.veiculo.CreateVeiculoResponse;
import br.com.mauriciopollis.locadoraveiculos.dto.response.veiculo.VeiculoResponse;
import br.com.mauriciopollis.locadoraveiculos.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<List<VeiculoResponse>> findAll() {
        List<VeiculoResponse> veiculoResponses = veiculoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(veiculoResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponse> findById(@PathVariable(name = "id") Long id) {
        VeiculoResponse veiculoResponse = veiculoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody UpdateVeiculoRequest updateVeiculoRequest) {
        veiculoService.update(id, updateVeiculoRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        veiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
