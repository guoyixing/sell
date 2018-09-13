package com.gyx.service.impl;

import com.gyx.dataobject.AuthResource;
import com.gyx.repository.AuthResourceRepository;
import com.gyx.service.AuthResourceService;
import com.gyx.utils.ConvertTree;
import com.gyx.utils.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gyx
 * @date 2018-06-27 13:21
 * @since 1.0.0
 */
@Service
public class AuthResourceServiceImpl implements AuthResourceService {
    @Autowired
    private AuthResourceRepository authResourceRepository;
    @Override
    public List<TreeNode<AuthResource>> toTree() {
        //获取数据集合
        List<AuthResource> list = authResourceRepository.findAll();
        //创建工具类
        ConvertTree<AuthResource> convertTree = new ConvertTree<>();
        //生成森林
        List<TreeNode<AuthResource>> forest = convertTree.getForest(list, "id", "parentId");
        return convertTree.getForest(list);
    }
}
