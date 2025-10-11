package com.github.caroyedu.client_contract_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PatchContractCostAmount {
    @NotBlank
    @NotEmpty
    @PositiveOrZero
    private BigDecimal costAmount;
}
