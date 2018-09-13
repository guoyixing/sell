package com.gyx.service;

import com.gyx.dataobject.AuthResource;
import com.gyx.dataobject.ProductInfo;
import com.gyx.dto.CartDTO;
import com.gyx.utils.TreeNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品service
 *
 * @author gyx
 * @date 2018-05-29 10:50
 * @since 1.0.0
 */
public interface AuthResourceService {
    List<TreeNode<AuthResource>> toTree();
}
