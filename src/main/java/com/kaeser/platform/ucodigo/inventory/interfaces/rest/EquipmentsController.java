package com.kaeser.platform.ucodigo.inventory.interfaces.rest;

import com.kaeser.platform.ucodigo.inventory.domain.services.EquipmentCommandService;
import com.kaeser.platform.ucodigo.inventory.domain.services.EquipmentQueryService;
import com.kaeser.platform.ucodigo.inventory.interfaces.rest.resources.CreateEquipmentResource;
import com.kaeser.platform.ucodigo.inventory.interfaces.rest.resources.EquipmentResource;
import com.kaeser.platform.ucodigo.inventory.interfaces.rest.transform.CreateEquipmentCommandFromResourceAssembler;
import com.kaeser.platform.ucodigo.inventory.interfaces.rest.transform.EquipmentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/v1/equipments", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Equipments", description = "Equipments Management Endpoints")
public class EquipmentsController {
    private final EquipmentQueryService equipmentQueryService;
    private final EquipmentCommandService equipmentCommandService;


    public EquipmentsController(EquipmentQueryService equipmentQueryService, EquipmentCommandService equipmentCommandService) {
        this.equipmentQueryService = equipmentQueryService;
        this.equipmentCommandService = equipmentCommandService;
    }

    /**
     * Creates a new Equipment
     * @param resource the resource containing the data to create the Equipment
     * @return the created Equipment
     */
    @PostMapping
    public ResponseEntity<EquipmentResource> createEquipment(@RequestBody CreateEquipmentResource resource) {
        if( resource == null) return ResponseEntity.badRequest().build(
        );

        var createEquipmentCommand = CreateEquipmentCommandFromResourceAssembler.toCommandFromResource(resource);
        var equipment = equipmentCommandService.handle(createEquipmentCommand);
        if (equipment.isEmpty()) return ResponseEntity.badRequest().build();
        var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipment.get());
        return new ResponseEntity<>(equipmentResource, HttpStatus.CREATED);
    }


}
