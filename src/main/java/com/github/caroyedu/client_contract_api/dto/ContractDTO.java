package com.github.caroyedu.client_contract_api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ContractDTO {
    private UUID publicId;
    private UUID clientPublicId;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal costAmount;
}
