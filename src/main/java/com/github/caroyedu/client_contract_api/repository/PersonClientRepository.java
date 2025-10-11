package com.github.caroyedu.client_contract_api.repository;

import com.github.caroyedu.client_contract_api.model.PersonClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonClientRepository extends JpaRepository<PersonClient, UUID> {
}
