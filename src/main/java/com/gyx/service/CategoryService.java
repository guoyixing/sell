package com.gyx.service;

import com.gyx.dataobject.ProductCategory;

import java.util.List;

/**
 * 目录Service
 *
 * @author gyx
 * @date 2018-05-29 09:13
 * @since 1.0.0
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
