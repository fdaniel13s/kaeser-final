package com.kaeser.platform.ucodigo.analytics.domain.model.commands;

public record CreateMeasurableIndicatorCommand(
        Long equipmentId,
        String equipmentType,
        String description,
        String symbol,
        Double thresholdMinimum,
        Double thresholdMaximum
) {
}
