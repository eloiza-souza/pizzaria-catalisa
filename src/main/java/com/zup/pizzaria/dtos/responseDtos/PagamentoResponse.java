package com.zup.pizzaria.dtos.responseDtos;

import java.math.BigDecimal;
import java.time.Instant;

public class PagamentoResponse {
    private Long pedidoID;
    private String formaPagamento;
    private BigDecimal valorPago;
    private Instant dataHoraPagamento;

    public PagamentoResponse(Long pedidoID, String formaPagamento, BigDecimal valorPago, Instant dataHoraPagamento) {
        this.pedidoID = pedidoID;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
        this.dataHoraPagamento =dataHoraPagamento;
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

    public Instant getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public void setDataHoraPagamento(Instant dataHoraPagamento) {
        this.dataHoraPagamento = dataHoraPagamento;
    }
}
