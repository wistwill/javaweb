package com.ian.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ian.mapper.UserRoleMapper;
import com.ian.model.UserRole;
import com.ian.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 *
 * UserRole 表数据服务层接口实现类
 *
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}