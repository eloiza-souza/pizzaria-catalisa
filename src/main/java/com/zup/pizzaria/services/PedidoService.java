package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.requestsDtos.PedidoRequest;
import com.zup.pizzaria.dtos.responseDtos.ClienteResponse;
import com.zup.pizzaria.dtos.responseDtos.PedidoResponse;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.ClienteRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;

    public PedidoService(PedidoRepository pedidoRepository, ClienteService clienteService) {
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
    }

    public PedidoResponse criarPedido(PedidoRequest pedidoRequest) {
        Cliente cliente = clienteService.obterClientePeloId(pedidoRequest.getClienteId());
        Pedido pedido = obterPedidoDePedidoRequest(pedidoRequest);
        pedidoRepository.save(pedido);
        return new PedidoResponse(cliente.getNome(), cliente.getEmail(), pedido.getDescricao(), pedido.getValorTotal());
    }

    public List<PedidoResponse> lerPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream()
                .map(this::obterPedidoResponseDePedido)
                .toList();
    }

    private PedidoResponse obterPedidoResponseDePedido(Pedido pedido) {
        Cliente cliente = clienteService.obterClientePeloId(pedido.getClienteId());
        return new PedidoResponse(cliente.getNome(), cliente.getEmail(), pedido.getDescricao(), pedido.getValorTotal());
    }

    private Pedido obterPedidoDePedidoRequest(PedidoRequest pedidoRequest) {
        return new Pedido(pedidoRequest.getDescricao(), pedidoRequest.getClienteId(), pedidoRequest.getValorTotal());
    }

}
