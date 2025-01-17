package com.zup.pizzaria.dtos.responseDtos;

import com.zup.pizzaria.util.DataUtil;

import java.math.BigDecimal;
import java.time.Instant;

public class PagamentoResponse {
    private Long pedidoID;
    private String formaPagamento;
    private BigDecimal valorPago;
    private String dataHoraPagamento;

    public PagamentoResponse(Long pedidoID, String formaPagamento, BigDecimal valorPago, Instant dataHoraPagamento) {
        this.pedidoID = pedidoID;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
        this.dataHoraPagamento = DataUtil.converteInstantParaString(dataHoraPagamento);
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

    public String getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public void setDataHoraPagamento(String dataHoraPagamento) {
        this.dataHoraPagamento = dataHoraPagamento;
    }

}
