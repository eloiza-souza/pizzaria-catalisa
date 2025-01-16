package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PagamentoDTO;
import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public PagamentoDTO criarPagamento(Pagamento pagamento){
        pagamentoRepository.save(pagamento);
        return new PagamentoDTO(pagamento.getPedidoId(), pagamento.getFormaPagamento(), pagamento.getValorPago());
    }
}
