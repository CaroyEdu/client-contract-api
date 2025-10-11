package com.github.caroyedu.client_contract_api.model.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, updatable = false)
    private UUID publicId;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private OffsetDateTime created;
    @UpdateTimestamp
    private OffsetDateTime updated;
    @Column(nullable = false)
    private Boolean deleted;

    @PrePersist
    public void prePersist() {
        if (publicId == null) publicId = UUID.randomUUID();
        if (deleted == null) deleted = false;
    }
}
