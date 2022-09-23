package io.github.marceloasfilho.msavaliadorcredito.service;

import feign.FeignException;
import io.github.marceloasfilho.msavaliadorcredito.client.MsCartoesClient;
import io.github.marceloasfilho.msavaliadorcredito.client.MsClientesClient;
import io.github.marceloasfilho.msavaliadorcredito.entity.*;
import io.github.marceloasfilho.msavaliadorcredito.exceptions.DadosClientesNotFoundException;
import io.github.marceloasfilho.msavaliadorcredito.exceptions.ErrorComunicacaoMicrosservicesException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoServiceImpl implements AvaliadorCreditoService {

    private final MsClientesClient msClientesClient;
    private final MsCartoesClient msCartoesClient;

    @Override
    public SituacaoCliente obterSituacaoCliente(String cpf)
            throws DadosClientesNotFoundException, ErrorComunicacaoMicrosservicesException {

        try {
            ResponseEntity<DadosCliente> dadosClienteResponse = this.msClientesClient.obterDadosClientePorCPF(cpf);
            ResponseEntity<List<CartaoCliente>> dadosCartaoClienteResponse = this.msCartoesClient.obterCartoesPorCpf(cpf);

            return SituacaoCliente
                    .builder()
                    .dadosCliente(dadosClienteResponse.getBody())
                    .cartoesCliente(dadosCartaoClienteResponse.getBody())
                    .build();
        } catch (FeignException.FeignClientException fe) {
            int status = fe.status();
            if (status == HttpStatus.NOT_FOUND.value()) {
                throw new DadosClientesNotFoundException();
            }
            throw new ErrorComunicacaoMicrosservicesException(fe.getMessage(), status);
        }
    }

    @Override
    public List<AvaliacaoCliente> realizarAvaliacao(String cpf, Long renda)
            throws DadosClientesNotFoundException, ErrorComunicacaoMicrosservicesException{

        try {
            ResponseEntity<DadosCliente> dadosClienteResponse = this.msClientesClient.obterDadosClientePorCPF(cpf);
            ResponseEntity<List<Cartao>> cartoesResponse = this.msCartoesClient.obterCartoesRendaMenorIgual(renda);

            List<Cartao> cartoes = cartoesResponse.getBody();

            List<AvaliacaoCliente> avaliacoesCliente = cartoes.stream().map(cartao -> {
                DadosCliente dadosCliente = dadosClienteResponse.getBody();

                BigDecimal limiteBasico = cartao.getLimite();
                BigDecimal idadeCliente = BigDecimal.valueOf(dadosCliente.getIdade());

                BigDecimal fator = idadeCliente.divide(BigDecimal.TEN);
                BigDecimal limiteAprovado = fator.multiply(limiteBasico);

                AvaliacaoCliente avaliacaoCliente = AvaliacaoCliente.builder()
                        .cartao(cartao.getNome())
                        .bandeira(cartao.getBandeira())
                        .limiteAprovado(limiteAprovado)
                        .build();

                return avaliacaoCliente;
            }).toList();

            return avaliacoesCliente;

        } catch (FeignException.FeignClientException fe) {
            int status = fe.status();
            if (status == HttpStatus.NOT_FOUND.value()) {
                throw new DadosClientesNotFoundException();
            }
            throw new ErrorComunicacaoMicrosservicesException(fe.getMessage(), status);
        }
    }
}
