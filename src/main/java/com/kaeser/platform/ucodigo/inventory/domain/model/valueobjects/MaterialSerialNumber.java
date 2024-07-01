package com.kaeser.platform.ucodigo.inventory.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Especifica que materialSerialNumber es un identificador único que Kaeser genera para sus equipos, el
 * cual sirve para identificarlos en los inventarios. Internamente es un embedded type con un valor
 * UUID que debe generarse al momento de registrarse. Por ello no se permite que se registre en la base
 * de datos dos equipments con el mismo valor de materialSerialNumber
 */
@Setter
@Getter
@Embeddable
public class MaterialSerialNumber {

    @NotBlank
    private String MaterialSerialNumber;

    public MaterialSerialNumber() {
        this.MaterialSerialNumber = UUID.randomUUID().toString();
    }
}