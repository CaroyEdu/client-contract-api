package com.github.caroyedu.client_contract_api.transformer;

import com.github.caroyedu.client_contract_api.dto.request.CreateContractRequest;
import com.github.caroyedu.client_contract_api.model.Client;
import com.github.caroyedu.client_contract_api.model.Contract;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Service
public class ContractTransformer {

    public void mapDtoToModel(CreateContractRequest dto, Contract model, Client client){
        model.setClient(client);
        model.setStartDate(dto.getStartDate() == null ? LocalDate.now() : dto.getStartDate());
        model.setEndDate(dto.getEndDate());
        model.setCostAmount(dto.getCostAmount());
        model.setUpdated(OffsetDateTime.now()); // Business Requirement
    }
}
