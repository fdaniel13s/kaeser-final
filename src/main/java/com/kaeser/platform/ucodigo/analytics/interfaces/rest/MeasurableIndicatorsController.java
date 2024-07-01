package com.kaeser.platform.ucodigo.analytics.interfaces.rest;

import com.kaeser.platform.ucodigo.analytics.domain.services.MeasurableIndicatorCommandService;
import com.kaeser.platform.ucodigo.analytics.domain.services.MeasurableIndicatorQueryService;
import com.kaeser.platform.ucodigo.analytics.interfaces.rest.resources.CreateMeasurableIndicatorResource;
import com.kaeser.platform.ucodigo.analytics.interfaces.rest.resources.MeasurableIndicatorResource;
import com.kaeser.platform.ucodigo.analytics.interfaces.rest.transform.CreateMeasurableIndicatorCommandFromResourceAssembler;
import com.kaeser.platform.ucodigo.analytics.interfaces.rest.transform.MeasurableIndicatorResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/v1/measurable-indicators", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Measurable Indicators")
public class MeasurableIndicatorsController {
    private final MeasurableIndicatorQueryService measurableIndicatorQueryService;
    private final MeasurableIndicatorCommandService measurableIndicatorCommandService;

    public MeasurableIndicatorsController(MeasurableIndicatorQueryService measurableIndicatorQueryService, MeasurableIndicatorCommandService measurableIndicatorCommandService) {
        this.measurableIndicatorQueryService = measurableIndicatorQueryService;
        this.measurableIndicatorCommandService = measurableIndicatorCommandService;
    }

    @PostMapping
    public ResponseEntity<MeasurableIndicatorResource> createMeasurableIndicator(CreateMeasurableIndicatorResource resource){
        var createMeasurableIndicatorCommand = CreateMeasurableIndicatorCommandFromResourceAssembler.fromResource(resource);
        var measurableIndicator = measurableIndicatorCommandService.handle(createMeasurableIndicatorCommand);
        if (measurableIndicator.isEmpty()) return ResponseEntity.badRequest().build();
        var measurableIndicatorResource = MeasurableIndicatorResourceFromEntityAssembler.fromEntity(measurableIndicator.get());
        return new ResponseEntity<>(measurableIndicatorResource, HttpStatus.CREATED);
    }
}
