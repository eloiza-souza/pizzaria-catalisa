package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.requestsDtos.ClienteRequest;
import com.zup.pizzaria.dtos.responseDtos.ClienteResponse;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponse criarCliente(ClienteRequest clienteRequest) {
        Cliente cliente = obterClienteDeClienteRequest(clienteRequest);
        clienteRepository.save(cliente);
        return new ClienteResponse(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
    }

    public List<ClienteResponse> lerClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(this::obterClienteResponseDeCliente)
                .toList();
    }

    private Cliente obterClienteDeClienteRequest(ClienteRequest clienteRequest) {
        return new Cliente(clienteRequest.getNome(), clienteRequest.getEmail(), clienteRequest.getTelefone());
    }

    private ClienteResponse obterClienteResponseDeCliente(Cliente cliente){
        return new ClienteResponse(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
    }
}
