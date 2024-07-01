package com.kaeser.platform.ucodigo.inventory.interfaces.rest.resources;

public record EquipmentResource(
        Long id,
        String equipmentType,
        String materialSerialNumber,
        String model
) {
}
