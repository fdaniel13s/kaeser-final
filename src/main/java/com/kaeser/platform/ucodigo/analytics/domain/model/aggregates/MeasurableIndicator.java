package com.kaeser.platform.ucodigo.analytics.domain.model.aggregates;

import com.kaeser.platform.ucodigo.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;
import com.kaeser.platform.ucodigo.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.ucodigo.shared.domain.model.valueobjects.EquipmentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Measurable Indicators, conformados por los atributos id (Long, Primary Key, Autogenerado), symbol (String,
 * Obligatorio), description (String, opcional), thresholdMinimum (Double, Obligatorio), thresholdMaximum
 * (Double, Obligatorio), equipmentType (EquipmentType, enumeration Obligatorio).
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
public class MeasurableIndicator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    @Getter
    private long id;

    @NotBlank
    @NotNull
    @Getter
    private String symbol;

    private String description;

    @NotNull
    @Getter
    private Double thresholdMinimum;

    @NotNull
    @Getter
    private Double thresholdMaximum;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    @Getter
    private Equipment equipment;

    public MeasurableIndicator(CreateMeasurableIndicatorCommand command, Equipment equipment) {
        this.symbol = command.symbol();
        this.description = command.description();
        this.thresholdMinimum = command.thresholdMinimum();
        this.thresholdMaximum = command.thresholdMaximum();
        this.equipment = equipment;
    }

}
