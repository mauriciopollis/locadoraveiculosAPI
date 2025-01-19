package br.com.mauriciopollis.locadoraveiculos.repository;

import br.com.mauriciopollis.locadoraveiculos.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
