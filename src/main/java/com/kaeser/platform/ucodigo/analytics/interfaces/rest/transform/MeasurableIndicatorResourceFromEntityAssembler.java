package com.kaeser.platform.ucodigo.analytics.interfaces.rest.transform;

import com.kaeser.platform.ucodigo.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.ucodigo.analytics.interfaces.rest.resources.MeasurableIndicatorResource;

public class MeasurableIndicatorResourceFromEntityAssembler {
    public static MeasurableIndicatorResource fromEntity(MeasurableIndicator entity) {
        return new MeasurableIndicatorResource(
                entity.getId(),
                entity.getEquipment().getId(),
                entity.getEquipment().getEquipmentType().toString(),
                entity.getDescription(),
                entity.getSymbol(),
                entity.getThresholdMinimum(),
                entity.getThresholdMaximum()
        );
    }
}
