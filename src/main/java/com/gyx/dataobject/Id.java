package com.gyx.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
public class Id {

    @javax.persistence.Id
    private Integer id;
}
