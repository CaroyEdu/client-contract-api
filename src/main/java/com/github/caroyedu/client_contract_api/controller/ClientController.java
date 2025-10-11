package com.github.caroyedu.client_contract_api.controller;

import com.github.caroyedu.client_contract_api.dto.request.CreateClientRequest;
import com.github.caroyedu.client_contract_api.model.Client;
import com.github.caroyedu.client_contract_api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody CreateClientRequest createClientRequest){
        try {
            Client client = clientService.createClient(createClientRequest);
            URI location = URI.create("/clients/" + client.getPublicId());
            return ResponseEntity.created(location).body(client);
        } catch (Exception e) {
            throw new RuntimeException("Exception while creating a new Client: " + e.getMessage(), e);
        }
    }
}
