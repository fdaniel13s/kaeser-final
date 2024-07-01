package com.kaeser.platform.ucodigo.analytics.application.internal.commandservices;

import com.kaeser.platform.ucodigo.analytics.domain.services.MeasurableIndicatorQueryService;
import com.kaeser.platform.ucodigo.analytics.infrastructure.persistence.jpa.repositories.MeasurableIndicatorRepository;
import com.kaeser.platform.ucodigo.inventory.domain.model.aggregates.Equipment;
import org.springframework.stereotype.Service;

@Service
public class MeasurableIndicatorQueryServiceImpl implements MeasurableIndicatorQueryService {
    private final MeasurableIndicatorRepository measurableIndicatorRepository;

    public MeasurableIndicatorQueryServiceImpl(MeasurableIndicatorRepository measurableIndicatorRepository) {
        this.measurableIndicatorRepository = measurableIndicatorRepository;
    }

    @Override
    public boolean existsBySymbolAndEquipment(String symbol, Equipment equipment) {
        return measurableIndicatorRepository.existsBySymbolAndEquipment(symbol, equipment);
    }
}
