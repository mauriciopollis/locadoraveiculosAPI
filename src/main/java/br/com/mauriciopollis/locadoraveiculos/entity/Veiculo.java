package br.com.mauriciopollis.locadoraveiculos.entity;

import br.com.mauriciopollis.locadoraveiculos.entity.enums.TipoVeiculoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    @Enumerated(EnumType.STRING)
    private TipoVeiculoEnum tipo;
    private BigDecimal diaria;
}
