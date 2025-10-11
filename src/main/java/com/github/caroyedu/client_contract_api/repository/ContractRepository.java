package com.github.caroyedu.client_contract_api.repository;

import com.github.caroyedu.client_contract_api.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
}
