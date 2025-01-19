package br.com.mauriciopollis.locadoraveiculos.repository;

import br.com.mauriciopollis.locadoraveiculos.entity.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
}
