package com.github.caroyedu.client_contract_api.repository;

import com.github.caroyedu.client_contract_api.model.CompanyClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyClientRepository extends JpaRepository<CompanyClient, Long> {
}
