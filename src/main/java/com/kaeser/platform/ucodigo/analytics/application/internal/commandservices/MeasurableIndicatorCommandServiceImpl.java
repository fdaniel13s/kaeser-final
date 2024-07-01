package com.kaeser.platform.ucodigo.analytics.application.internal.commandservices;

import com.kaeser.platform.ucodigo.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.ucodigo.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;
import com.kaeser.platform.ucodigo.analytics.domain.services.MeasurableIndicatorCommandService;
import com.kaeser.platform.ucodigo.analytics.infrastructure.persistence.jpa.repositories.MeasurableIndicatorRepository;
import com.kaeser.platform.ucodigo.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import com.kaeser.platform.ucodigo.shared.domain.model.valueobjects.EquipmentType;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeasurableIndicatorCommandServiceImpl implements MeasurableIndicatorCommandService {
    private final MeasurableIndicatorRepository measurableIndicatorRepository;
    private final EquipmentRepository equipmentRepository;

    public MeasurableIndicatorCommandServiceImpl(MeasurableIndicatorRepository measurableIndicatorRepository, EquipmentRepository equipmentRepository) {
        this.measurableIndicatorRepository = measurableIndicatorRepository;
        this.equipmentRepository = equipmentRepository;
    }


    @Override
    public Optional<MeasurableIndicator> handle(CreateMeasurableIndicatorCommand command) {
        if (!isThresholdValid(command))
            throw new IllegalArgumentException("Threshold values are invalid.");

        if (!isEquipmentValid(command))
            throw new IllegalArgumentException("Equipment type is invalid.");

        if (existsBySymbolAndEquipment(command))
            throw new IllegalArgumentException("Measurable indicator already exists.");

        var equipment = equipmentRepository.findById(command.equipmentId()).orElseThrow();

        var measurableIndicator = new MeasurableIndicator(command, equipment);
        try {
            measurableIndicatorRepository.save(measurableIndicator);
            return Optional.of(measurableIndicator);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving measurable indicator." , e);
        }

    }


    private boolean existsBySymbolAndEquipment(CreateMeasurableIndicatorCommand command){
        return measurableIndicatorRepository.existsBySymbolAndEquipment(
                command.symbol(),
                equipmentRepository.findByEquipmentTypeAndId(EquipmentType.valueOf(command.equipmentType()), command.equipmentId()).orElseThrow());
    }

    private boolean isThresholdValid(CreateMeasurableIndicatorCommand command){
        return command.thresholdMaximum() >= 0 && command.thresholdMinimum() >= 0 && command.thresholdMinimum() <= command.thresholdMaximum();
    }

    private boolean isEquipmentValid(CreateMeasurableIndicatorCommand command){
        try {
            EquipmentType.valueOf(command.equipmentType());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
