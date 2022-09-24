package io.github.marceloasfilho.msavaliadorcredito.service;

import io.github.marceloasfilho.msavaliadorcredito.entity.AvaliacaoCliente;
import io.github.marceloasfilho.msavaliadorcredito.entity.EmissaoCartao;
import io.github.marceloasfilho.msavaliadorcredito.entity.EmissaoCartaoProtocolo;
import io.github.marceloasfilho.msavaliadorcredito.entity.SituacaoCliente;
import io.github.marceloasfilho.msavaliadorcredito.exceptions.DadosClientesNotFoundException;
import io.github.marceloasfilho.msavaliadorcredito.exceptions.ErrorComunicacaoMicrosservicesException;
import io.github.marceloasfilho.msavaliadorcredito.exceptions.SolicitarEmissaoCartaoException;

import java.util.List;

public interface AvaliadorCreditoService {
    SituacaoCliente obterSituacaoCliente(String cpf) throws DadosClientesNotFoundException, ErrorComunicacaoMicrosservicesException;
    List<AvaliacaoCliente> realizarAvaliacao(String cpf, Long renda) throws ErrorComunicacaoMicrosservicesException, DadosClientesNotFoundException;
    EmissaoCartaoProtocolo solicitarEmissaoCartao(EmissaoCartao emissaoCartao) throws SolicitarEmissaoCartaoException;
}
