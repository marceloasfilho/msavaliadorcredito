package io.github.marceloasfilho.msavaliadorcredito.service;

import io.github.marceloasfilho.msavaliadorcredito.client.MsClientesClient;
import io.github.marceloasfilho.msavaliadorcredito.entity.DadosCliente;
import io.github.marceloasfilho.msavaliadorcredito.entity.SituacaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoServiceImpl implements AvaliadorCreditoService{

    private final MsClientesClient msClientesClient;
    @Override
    public SituacaoCliente obterSituacaoCliente(String cpf) {
        ResponseEntity<DadosCliente> dadosClienteResponse = this.msClientesClient.obterDadosClientePorCPF(cpf);
        return SituacaoCliente
                .builder()
                .dadosCliente(dadosClienteResponse.getBody())
                .build();
    }
}
