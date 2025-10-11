package com.github.caroyedu.client_contract_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class CompanyClient extends Client {
    @NotBlank
    @Column(unique = true)
    private String companyIdentifier;
}
