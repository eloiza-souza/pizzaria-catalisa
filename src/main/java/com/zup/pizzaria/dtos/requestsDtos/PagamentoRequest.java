package com.zup.pizzaria.dtos.requestsDtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class PagamentoRequest {

    @NotNull(message = "O ID do pedido não pode ser nulo.")
    private Long pedidoId;

    @NotBlank(message = "A forma de pagamento não pode estar em branco.")
    @Size(max = 50, message = "A forma de pagamento não pode ter mais de 50 caracteres.")
    private String formaPagamento;

    @NotNull(message = "O valor pago não pode ser nulo.")
    @DecimalMin(value = "0.0", inclusive = true, message = "O valor pago deve ser maior ou igual a zero.")
    private BigDecimal valorPago;

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
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

    public PagamentoRequest(Long pedidoId, String formaPagamento, BigDecimal valorPago) {
        this.pedidoId = pedidoId;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
    }
}
