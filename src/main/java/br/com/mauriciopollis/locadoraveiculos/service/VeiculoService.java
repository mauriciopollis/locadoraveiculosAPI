package br.com.mauriciopollis.locadoraveiculos.service;

import br.com.mauriciopollis.locadoraveiculos.dto.request.veiculo.CreateVeiculoRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.response.veiculo.CreateVeiculoResponse;
import br.com.mauriciopollis.locadoraveiculos.dto.response.veiculo.VeiculoResponse;
import br.com.mauriciopollis.locadoraveiculos.entity.Veiculo;
import br.com.mauriciopollis.locadoraveiculos.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public CreateVeiculoResponse create(CreateVeiculoRequest createVeiculoRequest) {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(createVeiculoRequest.marca());
        veiculo.setModelo(createVeiculoRequest.modelo());
        veiculo.setPlaca(createVeiculoRequest.placa());
        veiculo.setAno(createVeiculoRequest.ano());
        veiculo.setDiaria(createVeiculoRequest.diaria());
        veiculo.setTipo(createVeiculoRequest.tipo());
        veiculoRepository.save(veiculo);
        return new CreateVeiculoResponse(veiculo.getId());
    }

    public List<VeiculoResponse> findAll() {
        List<VeiculoResponse> veiculoResponses = veiculoRepository
                .findAll()
                .stream()
                .map(v -> new VeiculoResponse(
                        v.getId(),
                        v.getMarca(),
                        v.getModelo(),
                        v.getPlaca(),
                        v.getAno(),
                        v.getDiaria(),
                        v.getTipo()))
                .toList();
        return veiculoResponses;
    }
}
