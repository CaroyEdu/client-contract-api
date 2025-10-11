package com.github.caroyedu.client_contract_api.controller;

import com.github.caroyedu.client_contract_api.dto.request.CreateClientRequest;
import com.github.caroyedu.client_contract_api.dto.request.UpdateClientRequest;
import com.github.caroyedu.client_contract_api.model.Client;
import com.github.caroyedu.client_contract_api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

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
            throw new RuntimeException("Exception while creating a new client: " + e.getMessage(), e);
        }
    }

    @GetMapping("/{publicId}")
    public ResponseEntity<Client> getClient(@PathVariable UUID publicId){
        Optional<Client> client = clientService.getClient(publicId);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Client> updateClient(@RequestBody UpdateClientRequest updateClientRequest){
        try {
            Client client = clientService.updateClient(updateClientRequest);
            return ResponseEntity.ok().body(client);
        } catch (Exception e) {
            throw new RuntimeException("Exception while updating a client: " + e.getMessage(), e);
        }
    }
}
