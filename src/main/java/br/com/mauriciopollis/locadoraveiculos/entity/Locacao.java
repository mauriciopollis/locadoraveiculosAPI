package br.com.mauriciopollis.locadoraveiculos.entity;

import br.com.mauriciopollis.locadoraveiculos.entity.enums.StatusLocacaoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "locacao")
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(nullable = false)
    private Usuario cliente;
    @NotNull
    @Column(nullable = false)
    private Veiculo veiculo;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    @Enumerated(EnumType.STRING)
    private StatusLocacaoEnum status;
}
