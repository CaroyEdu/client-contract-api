package com.github.caroyedu.client_contract_api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class PersonClientDTO extends ClientDTO {
    private LocalDate birthdate;
}
