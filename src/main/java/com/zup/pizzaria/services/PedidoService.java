package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PedidoResponse;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.ClienteRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    public PedidoResponse criarPedido(Pedido pedido) {
        // Obtenho cliente
        Cliente cliente = clienteRepository
                .findById(pedido.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Salva pedido
        pedidoRepository.save(pedido);

        return new PedidoResponse(cliente.getNome(), cliente.getEmail(), pedido.getDescricao());
    }
}
