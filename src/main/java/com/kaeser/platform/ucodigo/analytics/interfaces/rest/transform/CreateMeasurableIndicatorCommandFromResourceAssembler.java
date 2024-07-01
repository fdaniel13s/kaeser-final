package com.kaeser.platform.ucodigo.analytics.interfaces.rest.transform;

import com.kaeser.platform.ucodigo.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;
import com.kaeser.platform.ucodigo.analytics.interfaces.rest.resources.CreateMeasurableIndicatorResource;

public class CreateMeasurableIndicatorCommandFromResourceAssembler {
    public static CreateMeasurableIndicatorCommand fromResource(CreateMeasurableIndicatorResource resource) {
        return new CreateMeasurableIndicatorCommand(
                resource.equipmentId(),
                resource.equipmentType(),
                resource.description(),
                resource.symbol(),
                resource.thresholdMinimum(),
                resource.thresholdMaximum()
        );
    }
}
