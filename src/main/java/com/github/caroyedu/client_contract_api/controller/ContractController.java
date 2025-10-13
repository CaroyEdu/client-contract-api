package com.github.caroyedu.client_contract_api.controller;

import com.github.caroyedu.client_contract_api.dto.ContractCostAmountDTO;
import com.github.caroyedu.client_contract_api.dto.ContractDTO;
import com.github.caroyedu.client_contract_api.dto.request.CreateContractRequest;
import com.github.caroyedu.client_contract_api.dto.request.PatchContractCostAmount;
import com.github.caroyedu.client_contract_api.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/contracts")
public class ContractController {
    private final ContractService contractService;

    @PostMapping
    public ResponseEntity<ContractDTO> createContract(@RequestBody CreateContractRequest createContractRequest){
        try{
            ContractDTO contract = contractService.createContract(createContractRequest);
            URI location = URI.create("/contracts/" + contract.getPublicId());
            return ResponseEntity.created(location).body(contract);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while creating a new contract: " + e.getMessage(), e);
        }
    }

    @PatchMapping("/{publicId}/costAmount")
    public ResponseEntity<ContractDTO> patchContractCostAmount(@PathVariable UUID publicId, @RequestBody PatchContractCostAmount patchRequest) {
        ContractDTO updatedContract = contractService.patchContractCostAmount(publicId, patchRequest);
        return ResponseEntity.ok(updatedContract);
    }

    // TODO Add filter for update date
    @GetMapping("/client/{clientPublicId}")
    public ResponseEntity<List<ContractDTO>> getContractsByClientPublicId(@PathVariable UUID clientPublicId){
        List<ContractDTO> contractList = contractService.getContractsByClientPublicId(clientPublicId);
        return ResponseEntity.ok(contractList);
    }

    @GetMapping("/totalContractCostAmount/client/{clientPublicId}")
    public ResponseEntity<ContractCostAmountDTO> getContractCostAmountByClientPublicId(@PathVariable UUID clientPublicId){
        ContractCostAmountDTO sum = contractService.getContractCostAmountByClientPublicId(clientPublicId);
        return ResponseEntity.ok(sum);
    }

}
