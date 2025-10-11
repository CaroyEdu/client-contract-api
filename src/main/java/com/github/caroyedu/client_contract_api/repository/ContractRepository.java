package com.github.caroyedu.client_contract_api.repository;

import com.github.caroyedu.client_contract_api.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    public Optional<Contract> findByPublicId(UUID publicId);
}
