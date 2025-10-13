package com.github.caroyedu.client_contract_api.service;

import com.github.caroyedu.client_contract_api.dto.ContractCostAmountDTO;
import com.github.caroyedu.client_contract_api.dto.ContractDTO;
import com.github.caroyedu.client_contract_api.dto.request.CreateContractRequest;
import com.github.caroyedu.client_contract_api.dto.request.PatchContractCostAmount;
import com.github.caroyedu.client_contract_api.model.Client;
import com.github.caroyedu.client_contract_api.model.Contract;
import com.github.caroyedu.client_contract_api.repository.ClientRepository;
import com.github.caroyedu.client_contract_api.repository.ContractRepository;
import com.github.caroyedu.client_contract_api.transformer.ContractTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;
    private final ClientRepository clientRepository;
    private final ContractTransformer contractTransformer;

    public ContractDTO createContract(CreateContractRequest createContractRequest){
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

        ContractDTO contractDTO = new ContractDTO();
        contractTransformer.mapDtoFromModel(contractDTO, contract);
        return contractDTO;
    }

    @Transactional
    public ContractDTO patchContractCostAmount(UUID publicId, PatchContractCostAmount patchRequest){
        Optional<Contract> optionalContract = contractRepository.findByPublicId(publicId);
        if(optionalContract.isEmpty()){
            throw new IllegalArgumentException("Contract not found for id: " + publicId);
        }

        Contract contract = optionalContract.get();
        contract.setCostAmount(patchRequest.getCostAmount());
        contract = contractRepository.save(contract);

        ContractDTO contractDTO = new ContractDTO();
        contractTransformer.mapDtoFromModel(contractDTO, contract);
        return contractDTO;
    }

    public List<ContractDTO> getContractsByClientPublicId(UUID publicId){
        List<Contract> contracts = contractRepository.findAllByClientPublicIdAndIsActive(publicId);
        List<ContractDTO> contractDTOS = new ArrayList<>();
        for(Contract contract : contracts){
            ContractDTO contractDTO = new ContractDTO();
            contractTransformer.mapDtoFromModel(contractDTO, contract);
            contractDTOS.add(contractDTO);
        }
        return contractDTOS;
    }

    public ContractCostAmountDTO getContractCostAmountByClientPublicId(UUID clientPublicId){
        BigDecimal sum = contractRepository.findTotalCostAmountByClientPublicId(clientPublicId);
        return new ContractCostAmountDTO(sum != null ? sum : BigDecimal.ZERO);
    }
}
