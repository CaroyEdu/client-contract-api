package com.github.caroyedu.client_contract_api.service;

import com.github.caroyedu.client_contract_api.dto.request.CreateContractRequest;
import com.github.caroyedu.client_contract_api.model.Client;
import com.github.caroyedu.client_contract_api.model.Contract;
import com.github.caroyedu.client_contract_api.repository.ClientRepository;
import com.github.caroyedu.client_contract_api.repository.ContractRepository;
import com.github.caroyedu.client_contract_api.transformer.ContractTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;
    private final ClientRepository clientRepository;
    private final ContractTransformer contractTransformer;

    public Contract createContract(CreateContractRequest createContractRequest){
        if(createContractRequest.getEndDate().isBefore(createContractRequest.getStartDate())){
            throw new IllegalArgumentException("The ending date cannot be before than the starting date");
        }

        Optional<Client> optionalClient = clientRepository.findClientByPublicId(createContractRequest.getClientPublicId());
        if(optionalClient.isEmpty()){
            throw new IllegalArgumentException("Client not found");
        }

        Client client = optionalClient.get();
        Contract contract = new Contract();
        contractTransformer.mapDtoToModel(createContractRequest, contract, client);
        contract = contractRepository.save(contract);
        return contract;
    }
}
