package io.github.marceloasfilho.msavaliadorcredito.service;

import io.github.marceloasfilho.msavaliadorcredito.entity.SituacaoCliente;

public interface AvaliadorCreditoService {
    SituacaoCliente obterSituacaoCliente(String cpf);
}
