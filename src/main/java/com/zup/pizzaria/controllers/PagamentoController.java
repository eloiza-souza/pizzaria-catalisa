package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.requestsDtos.PagamentoRequest;
import com.zup.pizzaria.dtos.responseDtos.PagamentoResponse;
import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.services.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<PagamentoResponse> criarPagamento(@Valid @RequestBody PagamentoRequest pagamentoRequest) {
Pagamento pagamento = new Pagamento(pagamentoRequest.getPedidoId(),pagamentoRequest.getFormaPagamento(), pagamentoRequest.getValorPago());
        PagamentoResponse pagamentoDTO = pagamentoService.criarPagamento(pagamento);
        return ResponseEntity.ok(pagamentoDTO);
    }

}
