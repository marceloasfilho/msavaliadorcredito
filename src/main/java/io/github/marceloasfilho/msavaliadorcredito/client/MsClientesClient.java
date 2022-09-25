package io.github.marceloasfilho.msavaliadorcredito.client;

import io.github.marceloasfilho.msavaliadorcredito.model.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msclientes", path = "/clientes")
public interface MsClientesClient {
    @GetMapping(path = "/obterDados", params = "cpf")
    ResponseEntity<DadosCliente> obterDadosClientePorCPF(@RequestParam("cpf") String cpf);
}
