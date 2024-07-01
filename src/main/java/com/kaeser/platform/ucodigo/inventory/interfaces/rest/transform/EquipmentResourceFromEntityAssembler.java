package com.kaeser.platform.ucodigo.inventory.interfaces.rest.transform;

import com.kaeser.platform.ucodigo.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.ucodigo.inventory.interfaces.rest.resources.EquipmentResource;

public class EquipmentResourceFromEntityAssembler {
    public static EquipmentResource toResourceFromEntity(Equipment entity) {
        return new EquipmentResource(
                entity.getId(),
                entity.getEquipmentType().toString(),
                entity.getMaterialSerialNumber().getMaterialSerialNumber(),
                entity.getModel()
        );
    }
}
