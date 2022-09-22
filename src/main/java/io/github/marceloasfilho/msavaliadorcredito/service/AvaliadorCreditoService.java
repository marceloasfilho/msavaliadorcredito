package io.github.marceloasfilho.msavaliadorcredito.service;

import io.github.marceloasfilho.msavaliadorcredito.entity.SituacaoCliente;
import io.github.marceloasfilho.msavaliadorcredito.exceptions.DadosClientesNotFoundException;
import io.github.marceloasfilho.msavaliadorcredito.exceptions.ErrorComunicacaoMicrosservicesException;

public interface AvaliadorCreditoService {
    SituacaoCliente obterSituacaoCliente(String cpf) throws DadosClientesNotFoundException, ErrorComunicacaoMicrosservicesException;
}
