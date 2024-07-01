package com.kaeser.platform.ucodigo.analytics.infrastructure.persistence.jpa.repositories;

import com.kaeser.platform.ucodigo.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.ucodigo.inventory.domain.model.aggregates.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurableIndicatorRepository extends JpaRepository<MeasurableIndicator, Long> {
    boolean existsBySymbolAndEquipment(String symbol, Equipment equipment);
}
