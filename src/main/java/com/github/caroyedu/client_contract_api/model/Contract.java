package com.github.caroyedu.client_contract_api.model;

import com.github.caroyedu.client_contract_api.model.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Contract extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Client client;
    @NotNull
    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = true, message = "Cost amount must be greater than zero")
    private BigDecimal costAmount;
}
