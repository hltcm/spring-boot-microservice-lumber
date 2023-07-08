package com.tomruk.lumberservice.repository;

import com.tomruk.lumberservice.model.LumberShipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LumberShipmentRepository extends JpaRepository<LumberShipment, Long> {
}
