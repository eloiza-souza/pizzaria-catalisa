package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.requestsDtos.PagamentoRequest;
import com.zup.pizzaria.dtos.responseDtos.PagamentoResponse;
import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.PagamentoRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public PagamentoResponse criarPagamento(PagamentoRequest pagamentoRequest) {
        Pedido pedido = pedidoRepository
                .findById(pagamentoRequest.getPedidoId())
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

        validarPagamento(pedido.getValorTotal(), pagamentoRequest.getValorPago());
        Pagamento pagamento = obterPagamentoDePagamentoRequest(pagamentoRequest);
        pagamentoRepository.save(pagamento);
        return new PagamentoResponse(pagamento.getPedidoId(), pagamento.getFormaPagamento(), pagamento.getValorPago(), pagamento.getDataHoraPagamento());
    }

    public void validarPagamento(BigDecimal valorTotalPedido, BigDecimal valorPago) {
        if (valorPago.compareTo(valorTotalPedido) < 0) {
            throw new IllegalArgumentException("O valor pago não pode ser menor que o valor total do pedido.");
        }
    }

    private Pagamento obterPagamentoDePagamentoRequest(PagamentoRequest pagamentoRequest) {
        return new Pagamento(pagamentoRequest.getPedidoId(), pagamentoRequest.getFormaPagamento(), pagamentoRequest.getValorPago());
    }
}
