package com.thoughtworks.xbyi.persona.domain.entity;

import com.thoughtworks.xbyi.persona.infrastructure.BasePersistentObject;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="persona_intrests")
@Data
public class Intrests extends BasePersistentObject {
    @Column
    @Getter
    @Setter
    private int outdoors;

    @Column
    @Getter
    @Setter
    private int travelEnthusiasts;

    @Column
    @Getter
    @Setter
    private int movieGoer;

    @Column
    @Getter
    @Setter
    private int techEnthusiasts;

    @Column
    @Getter
    @Setter
    private int fitnessEnthusiasts;

    @Column
    @Getter
    @Setter
    private int luxuries;

}
