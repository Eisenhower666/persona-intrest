package com.thoughtworks.xbyi.persona.infrastructure;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public class BasePersistentObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date created;

    @Column
    private Date updated;

    @Column
    private String createdBy;

    @Column
    private Integer status;
}
