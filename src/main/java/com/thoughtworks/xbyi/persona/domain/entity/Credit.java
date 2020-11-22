package com.thoughtworks.xbyi.persona.domain.entity;

import com.thoughtworks.xbyi.persona.infrastructure.BasePersistentObject;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="persona_credit")
@Data
public class Credit extends BasePersistentObject {

    @Column
    @Getter
    @Setter
    private String job;

    @Column
    @Getter
    @Setter
    private double income;

    @Column
    @Getter
    @Setter
    private double capital;

    @Column
    @Getter
    @Setter
    private double debt;

    @Column
    @Getter
    @Setter
    private int education;

    @Column
    @Getter
    @Setter
    private double score;
}
