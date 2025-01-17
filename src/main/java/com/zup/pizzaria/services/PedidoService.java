package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.requestsDtos.PedidoRequest;
import com.zup.pizzaria.dtos.responseDtos.PedidoResponse;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.ClienteRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoResponse criarPedido(PedidoRequest pedidoRequest) {
        Cliente cliente = new ClienteService().obterClientePeloId(pedidoRequest.getClienteId());
        Pedido pedido = obterPedidoDePedidoRequest(pedidoRequest);
        pedidoRepository.save(pedido);
        return new PedidoResponse(cliente.getNome(), cliente.getEmail(), pedido.getDescricao(), pedido.getValorTotal());
    }

    private Pedido obterPedidoDePedidoRequest(PedidoRequest pedidoRequest){
        return new Pedido(pedidoRequest.getDescricao(), pedidoRequest.getClienteId(), pedidoRequest.getValorTotal());
    }

}
