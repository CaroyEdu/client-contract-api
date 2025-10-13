package com.github.caroyedu.client_contract_api.repository;

import com.github.caroyedu.client_contract_api.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    Optional<Contract> findByPublicId(UUID publicId);

    @Query("SELECT c FROM Contract c JOIN c.client cl WHERE cl.publicId = :publicId AND (c.endDate IS NULL OR c.endDate > CURRENT_DATE) AND c.deleted = false")
    List<Contract> findAllByClientPublicIdAndIsActive(UUID publicId);
    @Query("SELECT SUM(c.costAmount) FROM Contract c JOIN c.client cl WHERE cl.publicId = :publicId AND (c.endDate IS NULL OR c.endDate > CURRENT_DATE) AND c.deleted = false")
    BigDecimal findTotalCostAmountByClientPublicId(UUID publicId);
}
