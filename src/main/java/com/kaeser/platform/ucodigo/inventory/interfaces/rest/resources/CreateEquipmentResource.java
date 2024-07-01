package com.kaeser.platform.ucodigo.inventory.interfaces.rest.resources;

public record CreateEquipmentResource(
        String equipmentType,
        String model
) {
}
