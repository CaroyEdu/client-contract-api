package com.github.caroyedu.client_contract_api.transformer;

import com.github.caroyedu.client_contract_api.dto.request.CreateClientRequest;
import com.github.caroyedu.client_contract_api.model.Client;
import com.github.caroyedu.client_contract_api.model.CompanyClient;
import com.github.caroyedu.client_contract_api.model.PersonClient;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

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
        model.setCreated(OffsetDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));
        model.setPublicId(UUID.randomUUID());
        model.setPhone(dto.getPhone());
        model.setDeleted(false);
    }
}
