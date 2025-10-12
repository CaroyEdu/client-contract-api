package com.github.caroyedu.client_contract_api.controller;

import com.github.caroyedu.client_contract_api.dto.ContractCostAmountDTO;
import com.github.caroyedu.client_contract_api.dto.request.CreateContractRequest;
import com.github.caroyedu.client_contract_api.dto.request.PatchContractCostAmount;
import com.github.caroyedu.client_contract_api.model.Contract;
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
    public ResponseEntity<Contract> createContract(@RequestBody CreateContractRequest createContractRequest){
        try{
            Contract contract = contractService.createContract(createContractRequest);
            URI location = URI.create("/contracts/" + contract.getPublicId());
            return ResponseEntity.created(location).body(contract);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while creating a new contract: " + e.getMessage(), e);
        }
    }

    @PatchMapping("/{publicId}")
    public ResponseEntity<Contract> patchContractCostAmount(@PathVariable UUID publicId, @RequestBody PatchContractCostAmount patchRequest) {
        Contract updatedContract = contractService.patchContractCostAmount(publicId, patchRequest);
        return ResponseEntity.ok(updatedContract);
    }

    // TODO Add filter for update date
    @GetMapping("/client/{publicId}")
    public ResponseEntity<List<Contract>> getContractsByClientPublicId(@PathVariable UUID publicId){
        List<Contract> contractList = contractService.getContractsByClientPublicId(publicId);
        return ResponseEntity.ok(contractList);
    }

    @GetMapping("/totalContractCostAmount/client/{clientPublicId}")
    public ResponseEntity<ContractCostAmountDTO> getContractCostAmountByClientPublicId(@PathVariable UUID clientPublicId){
        ContractCostAmountDTO sum = contractService.getContractCostAmountByClientPublicId(clientPublicId);
        return ResponseEntity.ok(sum);
    }

}
