package io.github.marceloasfilho.msavaliadorcredito.controller;

import io.github.marceloasfilho.msavaliadorcredito.entity.SituacaoCliente;
import io.github.marceloasfilho.msavaliadorcredito.service.AvaliadorCreditoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "avaliador-credito")
@Slf4j
public class AvaliadorCreditoController {

    public final AvaliadorCreditoService avaliadorCreditoService;

    public AvaliadorCreditoController(AvaliadorCreditoService avaliadorCreditoService) {
        this.avaliadorCreditoService = avaliadorCreditoService;
    }

    @GetMapping(path = "/status")
    public String status(){
        log.info("Status MSAVALIADORCREDITO");
        return "Status MSAVALIADORCREDITO";
    }

    @GetMapping(path = "situacao-cliente", params = "cpf")
    public ResponseEntity<SituacaoCliente> obterSituacaoCliente(@RequestParam("cpf") String cpf){
        SituacaoCliente situacaoCliente = this.avaliadorCreditoService.obterSituacaoCliente(cpf);
        return new ResponseEntity<>(situacaoCliente, HttpStatus.OK);
    }
}
