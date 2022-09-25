package io.github.marceloasfilho.msavaliadorcredito.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
    @Value("${queue.name.mscartoes-emissao-cartao}")
    private String emissaoCartaoFila;

    @Bean
    public Queue queueEmissaoCartao() {
        return new Queue(this.emissaoCartaoFila, true);
    }
}