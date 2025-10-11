package com.github.caroyedu.client_contract_api.service;

import com.github.caroyedu.client_contract_api.dto.request.CreateClientRequest;
import com.github.caroyedu.client_contract_api.model.Client;
import com.github.caroyedu.client_contract_api.model.CompanyClient;
import com.github.caroyedu.client_contract_api.model.PersonClient;
import com.github.caroyedu.client_contract_api.repository.CompanyClientRepository;
import com.github.caroyedu.client_contract_api.repository.PersonClientRepository;
import com.github.caroyedu.client_contract_api.transformer.ClientTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ClientService {

    private final PersonClientRepository personClientRepository;
    private final CompanyClientRepository companyClientRepository;
    private final ClientTransformer clientTransformer;
    private static final String PERSON = "person";
    private static final String COMPANY = "company";

    @Transactional
    public Client createClient(CreateClientRequest createClientRequest){
        String type = createClientRequest.getType();
        if(type.equals(PERSON)){
            PersonClient personClient = new PersonClient();
            clientTransformer.mapDtoToPersonModel(createClientRequest, personClient);
            personClient = personClientRepository.save(personClient);
            return personClient;
        } else if(type.equals(COMPANY)){
            CompanyClient companyClient = new CompanyClient();
            clientTransformer.mapDtoToCompanyModel(createClientRequest, companyClient);
            companyClient = companyClientRepository.save(companyClient);
            return companyClient;
        } else {
            throw new IllegalArgumentException("The Client has not been created as the requested received an unknown type: " + type);
        }
    }
}
