package com.github.caroyedu.client_contract_api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CompanyClientDTO extends ClientDTO {
    private String companyIdentifier;
}