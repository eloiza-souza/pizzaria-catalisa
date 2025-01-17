package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.requestsDtos.ClienteRequest;
import com.zup.pizzaria.dtos.requestsDtos.PedidoRequest;
import com.zup.pizzaria.dtos.responseDtos.ClienteResponse;
import com.zup.pizzaria.dtos.responseDtos.PedidoResponse;
import com.zup.pizzaria.services.PedidoService;
import jakarta.validation.Valid;
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
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> criarPedido(@Valid @RequestBody PedidoRequest pedidoRequest) {
        PedidoResponse pedidoDTO = pedidoService.criarPedido(pedidoRequest);
        return ResponseEntity.ok(pedidoDTO);
    }

    @GetMapping
    public List<PedidoResponse> lerPedidos(){
        return pedidoService.lerPedidos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponse> atualizarPedido(@PathVariable Long id, @Valid @RequestBody PedidoRequest request){
        PedidoResponse pedidoResponse = pedidoService.atualizarPedido(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

}
