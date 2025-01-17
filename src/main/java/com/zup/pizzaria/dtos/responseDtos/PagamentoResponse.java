package com.zup.pizzaria.dtos.responseDtos;

import java.math.BigDecimal;

public class PagamentoResponse {
    private Long pedidoID;
    private String formaPagamento;
    private BigDecimal valorPago;

    public PagamentoResponse(Long pedidoID, String formaPagamento, BigDecimal valorPago) {
        this.pedidoID = pedidoID;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
    }

    public Long getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(Long pedidoID) {
        this.pedidoID = pedidoID;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }
}
