package br.com.mauriciopollis.locadoraveiculos.service;

import br.com.mauriciopollis.locadoraveiculos.dto.request.veiculo.CreateVeiculoRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.request.veiculo.UpdateVeiculoRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.request.veiculo.VeiculoFilterRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.response.veiculo.CreateVeiculoResponse;
import br.com.mauriciopollis.locadoraveiculos.dto.response.veiculo.VeiculoResponse;
import br.com.mauriciopollis.locadoraveiculos.dto.response.veiculo.VeiculoResponsePage;
import br.com.mauriciopollis.locadoraveiculos.entity.Veiculo;
import br.com.mauriciopollis.locadoraveiculos.exception.ValidacaoException;
import br.com.mauriciopollis.locadoraveiculos.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public VeiculoResponsePage findAll(VeiculoFilterRequest veiculoFilterRequest) {

        Page<Veiculo> veiculoPage = veiculoRepository
                .findAllByMarcaContainsIgnoreCase(
                        veiculoFilterRequest.filter(),
                        PageRequest.of(veiculoFilterRequest.page(), veiculoFilterRequest.size())
                );

        List<VeiculoResponse> content = veiculoPage
                .getContent()
                .stream()
                .map(veiculo -> new VeiculoResponse(
                        veiculo.getId(),
                        veiculo.getMarca(),
                        veiculo.getModelo(),
                        veiculo.getPlaca(),
                        veiculo.getAno(),
                        veiculo.getDiaria(),
                        veiculo.getTipo()))
                .toList();

        VeiculoResponsePage veiculoResponsePage = new VeiculoResponsePage(
                veiculoPage.getTotalPages(),
                veiculoPage.getSize(),
                content
        );

        return veiculoResponsePage;
    }

    public VeiculoResponse findById(Long id) {
        Optional<Veiculo> veiculoDb = veiculoRepository.findById(id);
        if(veiculoDb.isEmpty()) {
            throw new ValidacaoException("Veículo de id " + id + " não existe");
        }
        VeiculoResponse veiculoResponse = new VeiculoResponse(
                veiculoDb.get().getId(),
                veiculoDb.get().getMarca(),
                veiculoDb.get().getModelo(),
                veiculoDb.get().getPlaca(),
                veiculoDb.get().getAno(),
                veiculoDb.get().getDiaria(),
                veiculoDb.get().getTipo()
        );
        return veiculoResponse;
    }

    public void update(Long id, UpdateVeiculoRequest updateVeiculoRequest) {
        Optional<Veiculo> veiculoDb = veiculoRepository.findById(id);
        if(veiculoDb.isEmpty()) {
            throw new ValidacaoException("Veículo de id "+ id + " não existe");
        }
        Veiculo veiculo = veiculoDb.get();
        if(updateVeiculoRequest.placa() != null) veiculo.setPlaca(updateVeiculoRequest.placa());
        if(updateVeiculoRequest.diaria() != null) veiculo.setDiaria(updateVeiculoRequest.diaria());
        veiculoRepository.save(veiculo);
    }

    public void delete(Long id) {
        Optional<Veiculo> veiculoDb = veiculoRepository.findById(id);
        if(veiculoDb.isEmpty()) {
            throw new ValidacaoException("Veículo de id " + id + " não existe");
        }
        veiculoRepository.deleteById(id);
    }
}
