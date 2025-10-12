package com.github.caroyedu.client_contract_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ClientDTO {
    private UUID publicId;
    private String name;
    private String email;
    private String phone;
    private List<ContractDTO> contracts;
}
