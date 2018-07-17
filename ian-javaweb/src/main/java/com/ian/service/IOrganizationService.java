package com.ian.service;

import com.ian.commons.result.Tree;
import com.ian.model.Organization;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 *
 * Organization 表数据服务层接口
 *
 */
public interface IOrganizationService extends IService<Organization> {

    List<Tree> selectTree();

    List<Organization> selectTreeGrid();

}