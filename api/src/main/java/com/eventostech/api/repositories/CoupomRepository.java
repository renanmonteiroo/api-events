package com.eventostech.api.repositories;

import com.eventostech.api.domain.cupom.Coupom;
import com.eventostech.api.domain.cupom.Coupom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoupomRepository extends JpaRepository<Coupom, UUID> {
}
