package com.ian.service;

import com.ian.commons.result.PageInfo;
import com.ian.model.SysLog;
import com.baomidou.mybatisplus.service.IService;

/**
 *
 * SysLog 表数据服务层接口
 *
 */
public interface ISysLogService extends IService<SysLog> {

    void selectDataGrid(PageInfo pageInfo);

}