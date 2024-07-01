package com.kaeser.platform.ucodigo.inventory.application.internal.commandservices;

import com.kaeser.platform.ucodigo.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.ucodigo.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.ucodigo.inventory.domain.services.EquipmentCommandService;
import com.kaeser.platform.ucodigo.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import com.kaeser.platform.ucodigo.shared.domain.model.valueobjects.EquipmentType;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentCommandServiceImpl implements EquipmentCommandService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentCommandServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }


    @Override
    public Optional<Equipment> handle(CreateEquipmentCommand command) {
        if (!IsValid(command)) {
            return Optional.empty(); //Return empty optional if command is not valid and in the controller
            //generate a bad request response
        }
        var equipment = new Equipment(command);
        try {
            equipmentRepository.save(equipment);
            return Optional.of(equipment);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving equipment." , e);
        }
    }

    private boolean IsValid(CreateEquipmentCommand command){
        return isEquipmentTypeValid(command);
    }

    //Valid if equipment type have a value of EquipmentType enum
    private boolean isEquipmentTypeValid(CreateEquipmentCommand command){
        try {
            EquipmentType.valueOf(command.equipmentType());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
