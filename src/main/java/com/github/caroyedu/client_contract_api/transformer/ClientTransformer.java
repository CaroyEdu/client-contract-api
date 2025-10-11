package com.github.caroyedu.client_contract_api.transformer;

import com.github.caroyedu.client_contract_api.dto.request.CreateClientRequest;
import com.github.caroyedu.client_contract_api.dto.request.UpdateClientRequest;
import com.github.caroyedu.client_contract_api.model.Client;
import com.github.caroyedu.client_contract_api.model.CompanyClient;
import com.github.caroyedu.client_contract_api.model.PersonClient;
import org.springframework.stereotype.Service;

@Service
public class ClientTransformer {

    public void mapDtoToPersonModel(CreateClientRequest dto, PersonClient model){
        mapDtoToModel(dto, model);
        model.setBirthdate(dto.getBirthdate());
    }

    public void mapDtoToCompanyModel(CreateClientRequest dto, CompanyClient model){
        mapDtoToModel(dto, model);
        model.setCompanyIdentifier(dto.getCompanyIdentifier());
    }

    private void mapDtoToModel(CreateClientRequest dto, Client model){
        model.setName(dto.getName());
        model.setEmail(dto.getEmail());
        model.setPhone(dto.getPhone());
    }

    public void updateModelFromDto(Client model, UpdateClientRequest dto){
        model.setName(dto.getName());
        model.setEmail(dto.getEmail());
        model.setPhone(dto.getPhone());
    }
}
