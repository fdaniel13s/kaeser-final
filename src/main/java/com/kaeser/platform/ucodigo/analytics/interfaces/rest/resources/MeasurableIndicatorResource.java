package com.kaeser.platform.ucodigo.analytics.interfaces.rest.resources;

public record MeasurableIndicatorResource(
Long id,
        Long equipmentId,
        String equipmentType,
        String description,
        String symbol,
        Double thresholdMinimum,
        Double thresholdMaximum
) {
}
