package io.github.marceloasfilho.msavaliadorcredito.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoCliente {
    private String nome;
    private String bandeira;
    private BigDecimal limite;
}
