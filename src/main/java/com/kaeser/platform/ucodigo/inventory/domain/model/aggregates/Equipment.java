package com.kaeser.platform.ucodigo.inventory.domain.model.aggregates;

import com.kaeser.platform.ucodigo.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.ucodigo.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.kaeser.platform.ucodigo.shared.domain.model.valueobjects.EquipmentType;
import com.kaeser.platform.ucodigo.inventory.domain.model.valueobjects.MaterialSerialNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;


@Entity
public class Equipment extends AuditableAbstractAggregateRoot<Equipment> {


    @Embedded
    @Column(name = "material_serial_number")
    @NotNull
    @Getter
    private final MaterialSerialNumber materialSerialNumber;

    @NotBlank
    @Setter
    @Getter
    private String model;

    @Enumerated(EnumType.STRING) //This is to store the enum value as a string in the database
    @NotNull
    @Setter
    @Getter
    private EquipmentType equipmentType;

    public Equipment() {
        this.materialSerialNumber = new MaterialSerialNumber();
    }

    public Equipment(CreateEquipmentCommand command) {
        this();
        this.model = command.model();
        this.equipmentType = EquipmentType.valueOf(command.equipmentType());
    }
}
