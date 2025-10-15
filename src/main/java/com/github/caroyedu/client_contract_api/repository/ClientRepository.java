package com.github.caroyedu.client_contract_api.repository;

import com.github.caroyedu.client_contract_api.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    @Query("SELECT c FROM Client c WHERE c.publicId = :publicId")
    Optional<Client> findClientByPublicId(UUID publicId);

    Optional<Client> findClientByEmail(String email);
}
