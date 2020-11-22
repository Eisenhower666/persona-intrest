package com.thoughtworks.xbyi.persona.domain.entity;

import com.thoughtworks.xbyi.persona.infrastructure.BasePersistentObject;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.EqualsAndHashCode;

@Entity(name="persona_consume")
@Data
//@NoArgsConstructor                 //无参构造
//@AllArgsConstructor                //有参构造
//@EqualsAndHashCode(callSuper=false)
public class ConsumeFeature extends BasePersistentObject {


    @Column
    @Getter
    @Setter
    private int businessTravel;

    @Column
    @Getter
    @Setter
    private int overseasTravel;

    @Column
    @Getter
    @Setter
    private int relaxTravel;

    @Column
    @Getter
    @Setter
    private int catering;

    @Column
    @Getter
    @Setter
    private int car;

    @Column
    @Getter
    @Setter
    private int mother;

    @Column
    @Getter
    @Setter
    private int financial;

    public ConsumeFeature(){}
    public ConsumeFeature(int i, int i1, int i2, int i3, int i4, int i5, int i6) {
        super();
    }
}
