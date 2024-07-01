package com.kaeser.platform.ucodigo.inventory.application.internal.queryservices;

import com.kaeser.platform.ucodigo.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.ucodigo.inventory.domain.services.EquipmentQueryService;
import com.kaeser.platform.ucodigo.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentQueryServiceImpl implements EquipmentQueryService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentQueryServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }


    @Override
    public Optional<Equipment> findById(Long id) {
        return equipmentRepository.findById(id);
    }
}
