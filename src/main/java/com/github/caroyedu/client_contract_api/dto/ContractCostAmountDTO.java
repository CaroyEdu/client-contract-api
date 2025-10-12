package com.github.caroyedu.client_contract_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class ContractCostAmountDTO {
    private BigDecimal totalCostAmount;
}
