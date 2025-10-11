package com.github.caroyedu.client_contract_api.model;

import com.github.caroyedu.client_contract_api.model.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class Client extends BaseEntity {
    @NotBlank
    private String name;
    @Email
    private String email;
    @Pattern(regexp = "\\+?[0-9\\- ]{7,15}", message = "Invalid phone number format")
    private String phone;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contract> contracts = new ArrayList<>();
}
