package io.github.marceloasfilho.msavaliadorcredito.service;

import io.github.marceloasfilho.msavaliadorcredito.client.MsCartoesClient;
import io.github.marceloasfilho.msavaliadorcredito.client.MsClientesClient;
import io.github.marceloasfilho.msavaliadorcredito.entity.CartaoCliente;
import io.github.marceloasfilho.msavaliadorcredito.entity.DadosCliente;
import io.github.marceloasfilho.msavaliadorcredito.entity.SituacaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoServiceImpl implements AvaliadorCreditoService{

    private final MsClientesClient msClientesClient;
    private final MsCartoesClient msCartoesClient;
    @Override
    public SituacaoCliente obterSituacaoCliente(String cpf) {
        ResponseEntity<DadosCliente> dadosClienteResponse = this.msClientesClient.obterDadosClientePorCPF(cpf);
        ResponseEntity<List<CartaoCliente>> dadosCartaoClienteResponse = this.msCartoesClient.obterCartoesPorCpf(cpf);

        return SituacaoCliente
                .builder()
                .dadosCliente(dadosClienteResponse.getBody())
                .cartoesCliente(dadosCartaoClienteResponse.getBody())
                .build();
    }
}
