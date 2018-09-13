package com.gyx.service;

import com.gyx.dataobject.ProductInfo;
import com.gyx.dto.CartDTO;
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
public interface ProductService {
    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    void increaseStock(List<CartDTO> cartDTOList);

    void decreaseStock(List<CartDTO> cartDTOList);

    ProductInfo onSale(String producId);

    ProductInfo offSale(String producId);


}
