package com.gyx.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gyx.enums.ProductStatusEnum;
import com.gyx.interfaces.TreeFid;
import com.gyx.interfaces.TreeId;
import com.gyx.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author gyx
 * @date 2018-05-29 09:57
 * @since 1.0.0
 */
@Entity
@Data
@DynamicUpdate
public class AuthResource {
    @Id
    @TreeId
    private String id;
    private String orgId;
    private BigDecimal productId;
    private Integer type;
    @TreeFid
    private String parentId;
    private String name;
    private String url;
    private Integer sort;
    private String note;
    private Integer rank;
}
