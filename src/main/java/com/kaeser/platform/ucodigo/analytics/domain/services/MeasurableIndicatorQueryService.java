package com.kaeser.platform.ucodigo.analytics.domain.services;

import com.kaeser.platform.ucodigo.inventory.domain.model.aggregates.Equipment;

public interface MeasurableIndicatorQueryService {
    boolean existsBySymbolAndEquipment(String symbol, Equipment equipment);
}
