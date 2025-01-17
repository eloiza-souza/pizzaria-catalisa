package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.requestsDtos.ClienteRequest;
import com.zup.pizzaria.dtos.requestsDtos.PagamentoRequest;
import com.zup.pizzaria.dtos.responseDtos.ClienteResponse;
import com.zup.pizzaria.dtos.responseDtos.PagamentoResponse;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.PagamentoRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoService pedidoService;

    public PagamentoResponse criarPagamento(PagamentoRequest pagamentoRequest) {
        Pedido pedido = pedidoService.obterPedidoPeloId(pagamentoRequest.getPedidoId());
        validarPagamento(pedido.getValorTotal(), pagamentoRequest.getValorPago());
        Pagamento pagamento = obterPagamentoDePagamentoRequest(pagamentoRequest);
        pagamentoRepository.save(pagamento);
        return obterPagamentoResponseDePagamento(pagamento);
    }

    public void validarPagamento(BigDecimal valorTotalPedido, BigDecimal valorPago) {
        if (valorPago.compareTo(valorTotalPedido) < 0) {
            throw new IllegalArgumentException("O valor pago não pode ser menor que o valor total do pedido.");
        }
    }

    public List<PagamentoResponse> lerPagamentos(){
        List<Pagamento> pagamentos = pagamentoRepository.findAll();
        return pagamentos.stream()
                .map(this::obterPagamentoResponseDePagamento)
                .toList();
    }

    public PagamentoResponse atualizarPagamento(Long id, PagamentoRequest request){
        Pagamento pagamento = obterPagamentoPeloId(id);
        pagamento.setPedidoId(request.getPedidoId());
        pagamento.setFormaPagamento(request.getFormaPagamento());
        pagamento.setValorPago(request.getValorPago());
        pagamentoRepository.save(pagamento);
        return obterPagamentoResponseDePagamento(pagamento);
    }

    private Pagamento obterPagamentoDePagamentoRequest(PagamentoRequest pagamentoRequest) {
        return new Pagamento(pagamentoRequest.getPedidoId(), pagamentoRequest.getFormaPagamento(), pagamentoRequest.getValorPago());
    }

    private PagamentoResponse obterPagamentoResponseDePagamento(Pagamento pagamento){
        return new PagamentoResponse(pagamento.getPedidoId(), pagamento.getFormaPagamento(), pagamento.getValorPago(), pagamento.getDataHoraPagamento());
    }

    private Pagamento obterPagamentoPeloId(Long pagamentoId) {
        return pagamentoRepository.findById(pagamentoId)
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado"));
    }
}
