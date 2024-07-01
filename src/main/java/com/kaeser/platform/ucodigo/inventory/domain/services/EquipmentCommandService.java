package com.kaeser.platform.ucodigo.inventory.domain.services;

import com.kaeser.platform.ucodigo.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.ucodigo.inventory.domain.model.commands.CreateEquipmentCommand;

import java.util.Optional;

public interface EquipmentCommandService {
    Optional<Equipment> handle(CreateEquipmentCommand command);
}
