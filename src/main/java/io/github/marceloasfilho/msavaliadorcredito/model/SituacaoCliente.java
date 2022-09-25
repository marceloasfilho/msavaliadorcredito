package io.github.marceloasfilho.msavaliadorcredito.model;

import io.github.marceloasfilho.msavaliadorcredito.model.CartaoCliente;
import io.github.marceloasfilho.msavaliadorcredito.model.DadosCliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SituacaoCliente {
    private DadosCliente dadosCliente;
    private List<CartaoCliente> cartoesCliente;
}
