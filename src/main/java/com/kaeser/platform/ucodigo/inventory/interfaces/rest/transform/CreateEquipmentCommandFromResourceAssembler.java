package com.kaeser.platform.ucodigo.inventory.interfaces.rest.transform;

import com.kaeser.platform.ucodigo.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.ucodigo.inventory.interfaces.rest.resources.CreateEquipmentResource;

public class CreateEquipmentCommandFromResourceAssembler {
    public static CreateEquipmentCommand toCommandFromResource(CreateEquipmentResource resource) {
        return new CreateEquipmentCommand(
                resource.equipmentType(),
                resource.model()
        );
    }
}
