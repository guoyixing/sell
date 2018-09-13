package com.gyx.repository;

import com.gyx.dataobject.AuthResource;
import com.gyx.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 *
 * @author gyx
 * @date 2018-05-28 16:22
 * @since 1.0.0
 */
public interface AuthResourceRepository extends JpaRepository<AuthResource,String>{
}
