package com.kaeser.platform.ucodigo.analytics.domain.services;

import com.kaeser.platform.ucodigo.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.ucodigo.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;

import java.util.Optional;

public interface MeasurableIndicatorCommandService {
    Optional<MeasurableIndicator> handle(CreateMeasurableIndicatorCommand command);
}
