package io.github.marceloasfilho.msavaliadorcredito.service;

import io.github.marceloasfilho.msavaliadorcredito.exceptions.DadosClientesNotFoundException;
import io.github.marceloasfilho.msavaliadorcredito.exceptions.ErrorComunicacaoMicrosservicesException;
import io.github.marceloasfilho.msavaliadorcredito.exceptions.SolicitarEmissaoCartaoException;
import io.github.marceloasfilho.msavaliadorcredito.model.AvaliacaoCliente;
import io.github.marceloasfilho.msavaliadorcredito.model.EmissaoCartao;
import io.github.marceloasfilho.msavaliadorcredito.model.EmissaoCartaoProtocolo;
import io.github.marceloasfilho.msavaliadorcredito.model.SituacaoCliente;

import java.util.List;

public interface AvaliadorCreditoService {
    SituacaoCliente obterSituacaoCliente(String cpf) throws DadosClientesNotFoundException, ErrorComunicacaoMicrosservicesException;

    List<AvaliacaoCliente> realizarAvaliacao(String cpf, Long renda) throws ErrorComunicacaoMicrosservicesException, DadosClientesNotFoundException;

    EmissaoCartaoProtocolo solicitarEmissaoCartao(EmissaoCartao emissaoCartao) throws SolicitarEmissaoCartaoException;
}
