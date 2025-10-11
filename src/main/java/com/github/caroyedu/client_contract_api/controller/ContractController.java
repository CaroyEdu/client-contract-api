package com.github.caroyedu.client_contract_api.controller;

import com.github.caroyedu.client_contract_api.dto.request.CreateContractRequest;
import com.github.caroyedu.client_contract_api.model.Contract;
import com.github.caroyedu.client_contract_api.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/contracts")
public class ContractController {
    private final ContractService contractService;

    @PostMapping
    public ResponseEntity<Contract> createContract(@RequestBody CreateContractRequest createContractRequest){
        try{
            Contract contract = contractService.createContract(createContractRequest);
            URI location = URI.create("/contracts/" + contract.getPublicId());
            return ResponseEntity.created(location).body(contract);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while creating a new contract: " + e.getMessage(), e);
        }
    }
}
