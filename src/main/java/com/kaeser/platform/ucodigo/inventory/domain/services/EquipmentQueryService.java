package com.kaeser.platform.ucodigo.inventory.domain.services;

import com.kaeser.platform.ucodigo.inventory.domain.model.aggregates.Equipment;

import java.util.Optional;

public interface EquipmentQueryService {

    Optional<Equipment> findById(Long id);
}
