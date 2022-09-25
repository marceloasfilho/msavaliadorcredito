package io.github.marceloasfilho.msavaliadorcredito.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.marceloasfilho.msavaliadorcredito.model.EmissaoCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmissaoCartaoPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queueEmissaoCartao;

    public void solicitarCartao(EmissaoCartao emissaoCartao) throws JsonProcessingException {
        String json = this.toJson(emissaoCartao);
        this.rabbitTemplate.convertAndSend(this.queueEmissaoCartao.getName(), json);
    }

    private String toJson(EmissaoCartao emissaoCartao) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(emissaoCartao);
    }
}