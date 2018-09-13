package com.gyx.repository;

import com.gyx.dataobject.OrderMaster;
import com.gyx.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 *
 * @author gyx
 * @date 2018-05-28 16:22
 * @since 1.0.0
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String>{

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid,Pageable pageable);
}
