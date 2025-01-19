package br.com.mauriciopollis.locadoraveiculos.service;

import br.com.mauriciopollis.locadoraveiculos.repository.LocacaoRepository;
import br.com.mauriciopollis.locadoraveiculos.repository.UsuarioRepository;
import br.com.mauriciopollis.locadoraveiculos.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocacaoService {

    private final UsuarioRepository usuarioRepository;
    private final VeiculoRepository veiculoRepository;
    private final LocacaoRepository locacaoRepository;
}
