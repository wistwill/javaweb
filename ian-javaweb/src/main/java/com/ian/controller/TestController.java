package com.ian.controller;

import com.ian.commons.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

/**
 * @description：测试Controller
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    /**
     * 图标测试
     * 
     * @RequiresRoles shiro 权限注解
     * 
     * @return
     */
    @RequiresRoles("test")
    @GetMapping("/dataGrid")
    public String dataGrid() {
        return "admin/test";
    }

    /**
     * 下载测试
     * @return
     */
    @GetMapping("/down")
    public ResponseEntity<Resource> down() {
        File file = new File("/Users/lcm/Downloads/归档.zip");
        return download(file);
    }
}
