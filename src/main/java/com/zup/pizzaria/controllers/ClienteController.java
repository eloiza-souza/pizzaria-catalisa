package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.ClienteRequest;
import com.zup.pizzaria.dtos.ClienteResponse;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponse> criarCliente(@Valid @RequestBody ClienteRequest clienteRequest) {
        ClienteResponse clienteDTO = clienteService.criarCliente(clienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
    }
}
