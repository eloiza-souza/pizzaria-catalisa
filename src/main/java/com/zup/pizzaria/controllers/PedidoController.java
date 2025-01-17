package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.PedidoResponse;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> criarPedido(@RequestBody Pedido pedido) {
        PedidoResponse pedidoDTO = pedidoService.criarPedido(pedido);
        return ResponseEntity.ok(pedidoDTO);
    }
}
