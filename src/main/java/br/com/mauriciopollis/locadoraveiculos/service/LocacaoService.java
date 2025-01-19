package br.com.mauriciopollis.locadoraveiculos.service;

import br.com.mauriciopollis.locadoraveiculos.dto.request.locacao.CreateLocacaoRequest;
import br.com.mauriciopollis.locadoraveiculos.dto.response.locacao.CreateLocacaoResponse;
import br.com.mauriciopollis.locadoraveiculos.entity.Locacao;
import br.com.mauriciopollis.locadoraveiculos.entity.Usuario;
import br.com.mauriciopollis.locadoraveiculos.entity.Veiculo;
import br.com.mauriciopollis.locadoraveiculos.entity.enums.StatusLocacaoEnum;
import br.com.mauriciopollis.locadoraveiculos.exception.ValidacaoException;
import br.com.mauriciopollis.locadoraveiculos.repository.LocacaoRepository;
import br.com.mauriciopollis.locadoraveiculos.repository.UsuarioRepository;
import br.com.mauriciopollis.locadoraveiculos.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocacaoService {

    private final UsuarioRepository usuarioRepository;
    private final VeiculoRepository veiculoRepository;
    private final LocacaoRepository locacaoRepository;

    public CreateLocacaoResponse create(CreateLocacaoRequest createLocacaoRequest) {
        Optional<Usuario> usuarioDb = usuarioRepository.findById(createLocacaoRequest.clienteId());
        if(usuarioDb.isEmpty()) {
            throw new ValidacaoException("Usuário de id " + createLocacaoRequest.clienteId() + " não existe");
        }
        Optional<Veiculo> veiculoDb = veiculoRepository.findById(createLocacaoRequest.veiculoId());
        if(veiculoDb.isEmpty()) {
            throw new ValidacaoException("Veículo de id " + createLocacaoRequest.veiculoId() + " não existe");
        }
        if(createLocacaoRequest.dataInicio().isAfter(createLocacaoRequest.dataFinal())) {
            throw new ValidacaoException("A data inicial da locação não pode ser posterior à data final da locação");
        }

        Locacao locacao = new Locacao();
        locacao.setCliente(usuarioDb.get());
        locacao.setVeiculo(veiculoDb.get());
        locacao.setDataInicio(createLocacaoRequest.dataInicio());
        locacao.setDataFinal(createLocacaoRequest.dataFinal());
        locacao.setStatus(StatusLocacaoEnum.ATIVA);

        locacaoRepository.save(locacao);
        return new CreateLocacaoResponse(locacao.getId());
    }
}
