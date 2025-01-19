package br.com.mauriciopollis.locadoraveiculos.repository;

import br.com.mauriciopollis.locadoraveiculos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
