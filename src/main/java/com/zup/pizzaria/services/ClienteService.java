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
        return obterClienteResponseDeCliente(cliente);
    }

    public List<ClienteResponse> lerClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(this::obterClienteResponseDeCliente)
                .toList();
    }

    public Cliente obterClientePeloId(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    }

    public ClienteResponse atualizarCliente(Long id, ClienteRequest request){
        Cliente cliente = obterClientePeloId(id);
        cliente.setNome(request.getNome());
        cliente.setEmail(request.getEmail());
        cliente.setTelefone(request.getTelefone());
        clienteRepository.save(cliente);
        return obterClienteResponseDeCliente(cliente);
    }

    private Cliente obterClienteDeClienteRequest(ClienteRequest clienteRequest) {
        return new Cliente(clienteRequest.getNome(), clienteRequest.getEmail(), clienteRequest.getTelefone());
    }

    private ClienteResponse obterClienteResponseDeCliente(Cliente cliente) {
        return new ClienteResponse(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
    }
}
