package com.thoughtworks.xbyi.persona.domain.entity;

import com.thoughtworks.xbyi.persona.infrastructure.BasePersistentObject;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="persona_demographic")
@Data
public class Demographic extends BasePersistentObject {
    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private Integer gender;

    @Column
    @Getter
    @Setter
    private Integer age;

    @Column
    @Getter
    @Setter
    private String telephone;

    @Column
    @Getter
    @Setter
    private String email;

    @Column
    @Getter
    @Setter
    private String address;
}
