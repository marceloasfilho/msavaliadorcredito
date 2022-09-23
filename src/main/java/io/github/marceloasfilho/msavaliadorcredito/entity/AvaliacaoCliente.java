package io.github.marceloasfilho.msavaliadorcredito.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AvaliacaoCliente {
    private String cartao;
    private String bandeira;
    private BigDecimal limiteAprovado;
}
