package com.gyx.repository;

import com.gyx.dataobject.Id;
import com.gyx.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 *
 * @author gyx
 * @date 2018-05-28 16:22
 * @since 1.0.0
 */
public interface IdRepository extends JpaRepository<Id,String>{

}
