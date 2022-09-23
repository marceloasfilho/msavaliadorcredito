package io.github.marceloasfilho.msavaliadorcredito.service;

import io.github.marceloasfilho.msavaliadorcredito.entity.AvaliacaoCliente;
import io.github.marceloasfilho.msavaliadorcredito.entity.SituacaoCliente;
import io.github.marceloasfilho.msavaliadorcredito.exceptions.DadosClientesNotFoundException;
import io.github.marceloasfilho.msavaliadorcredito.exceptions.ErrorComunicacaoMicrosservicesException;

import java.util.List;

public interface AvaliadorCreditoService {
    SituacaoCliente obterSituacaoCliente(String cpf) throws DadosClientesNotFoundException, ErrorComunicacaoMicrosservicesException;
    List<AvaliacaoCliente> realizarAvaliacao(String cpf, Long renda) throws ErrorComunicacaoMicrosservicesException, DadosClientesNotFoundException;
}
