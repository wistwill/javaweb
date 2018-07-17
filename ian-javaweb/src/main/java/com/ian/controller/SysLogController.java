package com.ian.controller;

import com.ian.commons.result.PageInfo;
import com.ian.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 日志管理
 * @author：Ian
 * @date：2018年6月26日10:10:06
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private ISysLogService sysLogService;

    @GetMapping("/manager")
    public String manager() {
        return "admin/syslog";
    }

    @PostMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(Integer page, Integer rows,
                             @RequestParam(value = "sort" , defaultValue = "create_time") String sort,
                             @RequestParam(value = "order" , defaultValue = "DESC") String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        sysLogService.selectDataGrid(pageInfo);
        return pageInfo;
    }
}
