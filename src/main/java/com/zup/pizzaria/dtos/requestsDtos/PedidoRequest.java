package com.zup.pizzaria.dtos.requestsDtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class PedidoRequest {
    @NotBlank(message = "A descrição não pode ser vazia ou nula")
    private String descricao;

    @NotBlank(message = "O clienteId não pode ser vazio ou nulo.")
    @Pattern(regexp = "\\d+", message = "O id do cliente deve conter apenas números.")
    private Long clienteId;

    @NotBlank(message = "O valor total do pedido não pode ser vazio ou nulo")
    @PositiveOrZero
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
