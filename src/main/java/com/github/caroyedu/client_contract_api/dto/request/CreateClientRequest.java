package com.github.caroyedu.client_contract_api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateClientRequest {
    @NotBlank
    private String type; // "person" or "company"

    @NotBlank
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "\\+?[0-9\\- ]{7,15}")
    private String phone;

    private LocalDate birthdate;
    private String companyIdentifier;
}
