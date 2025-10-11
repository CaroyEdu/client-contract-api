package com.github.caroyedu.client_contract_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class CreateContractRequest {
    @NotBlank
    private UUID clientPublicId;
    private LocalDate startDate;
    private LocalDate endDate;
    @NotBlank
    private BigDecimal costAmount;
}
