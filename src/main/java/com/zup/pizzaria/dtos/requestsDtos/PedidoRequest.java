package com.zup.pizzaria.dtos.requestsDtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class PedidoRequest {
    @NotBlank(message = "A descrição não pode ser vazia ou nula")
    private String descricao;

    @NotNull(message = "O clienteId não pode ser nulo.")
    private Long clienteId;

    @NotNull(message = "O valor total do pedido não pode ser nulo")
    @DecimalMin(value = "0.0", inclusive = true, message = "O valor pago deve ser maior ou igual a zero.")
    private BigDecimal valorTotal;

    public PedidoRequest(String descricao, Long clienteId, BigDecimal valorTotal) {
        this.descricao = descricao;
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
