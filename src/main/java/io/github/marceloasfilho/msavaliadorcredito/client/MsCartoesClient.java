package io.github.marceloasfilho.msavaliadorcredito.client;

import io.github.marceloasfilho.msavaliadorcredito.entity.CartaoCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "mscartoes", path = "cartoes")
public interface MsCartoesClient {
    @GetMapping(path = "/cpf", params = "cpf")
    public ResponseEntity<List<CartaoCliente>> obterCartoesPorCpf(@RequestParam("cpf") String cpf);
}