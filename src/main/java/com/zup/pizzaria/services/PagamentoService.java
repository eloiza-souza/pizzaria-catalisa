package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PagamentoDTO;
import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.PagamentoRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public PagamentoDTO criarPagamento(Pagamento pagamento) {
        // Obtém o pedido
        Pedido pedido = pedidoRepository
                .findById(pagamento.getPedidoId())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pagamento.validarPagamento(pedido.getValorTotal());
        pagamentoRepository.save(pagamento);
        return new PagamentoDTO(pagamento.getPedidoId(), pagamento.getFormaPagamento(), pagamento.getValorPago());
    }
}
