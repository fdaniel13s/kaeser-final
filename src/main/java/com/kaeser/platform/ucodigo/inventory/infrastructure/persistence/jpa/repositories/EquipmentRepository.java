package com.kaeser.platform.ucodigo.inventory.infrastructure.persistence.jpa.repositories;

import com.kaeser.platform.ucodigo.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.ucodigo.shared.domain.model.valueobjects.EquipmentType;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Long>{
    Optional<Equipment> findByEquipmentTypeAndId(@NotNull EquipmentType equipmentType, Long id);
}
