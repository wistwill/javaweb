package com.ian.service;

import com.ian.commons.result.Tree;
import com.ian.commons.shiro.ShiroUser;
import com.ian.model.Resource;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 *
 * Resource 表数据服务层接口
 *
 */
public interface IResourceService extends IService<Resource> {

    List<Resource> selectAll();

    List<Tree> selectAllMenu();

    List<Tree> selectAllTree();

    List<Tree> selectTree(ShiroUser shiroUser);

}