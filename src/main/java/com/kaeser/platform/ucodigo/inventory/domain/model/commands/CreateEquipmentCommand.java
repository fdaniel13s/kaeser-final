package com.kaeser.platform.ucodigo.inventory.domain.model.commands;

public record CreateEquipmentCommand(
        String equipmentType,
        String model
) {
}
