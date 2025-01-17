package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.requestsDtos.ClienteRequest;
import com.zup.pizzaria.dtos.requestsDtos.PagamentoRequest;
import com.zup.pizzaria.dtos.responseDtos.ClienteResponse;
import com.zup.pizzaria.dtos.responseDtos.PagamentoResponse;
import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.services.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<PagamentoResponse> criarPagamento(@Valid @RequestBody PagamentoRequest pagamentoRequest) {
        PagamentoResponse pagamentoResponse = pagamentoService.criarPagamento(pagamentoRequest);
        return ResponseEntity.ok(pagamentoResponse);
    }

    @GetMapping
    public List<PagamentoResponse> lerPagamentos(){
        return pagamentoService.lerPagamentos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoResponse> atualizarPagamento(@PathVariable Long id, @Valid @RequestBody PagamentoRequest request){
        PagamentoResponse pagamentoResponse =pagamentoService.atualizarPagamento(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPagamento(@PathVariable Long id) {
        pagamentoService.deletarPagamento(id);
        return ResponseEntity.noContent().build();
    }

}
