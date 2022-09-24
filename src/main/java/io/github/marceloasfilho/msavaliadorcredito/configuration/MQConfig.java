package io.github.marceloasfilho.msavaliadorcredito.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;

@Configurable
public class MQConfig {
    @Value("${queue.name.mscartoes-emissao-cartao}")
    private String emissaoCartaoFila;

    public Queue queueEmissaoCartao() {
        return new Queue(this.emissaoCartaoFila, true);
    }
}