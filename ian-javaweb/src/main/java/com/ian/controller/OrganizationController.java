package com.ian.controller;

import com.ian.commons.base.BaseController;
import com.ian.model.Organization;
import com.ian.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;

/**
 * @description：部门管理
 * @author：Ian
 * @date：2018年6月26日10:10:06
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController extends BaseController {

    @Autowired
    private IOrganizationService organizationService;

    /**
     * 部门管理主页
     *
     * @return
     */
    @GetMapping(value = "/manager")
    public String manager() {
        return "admin/organization/organization";
    }

    /**
     * 部门资源树
     *
     * @return
     */
    @PostMapping(value = "/tree")
    @ResponseBody
    public Object tree() {
        return organizationService.selectTree();
    }

    /**
     * 部门列表
     *
     * @return
     */
    @RequestMapping("/treeGrid")
    @ResponseBody
    public Object treeGrid() {
        return organizationService.selectTreeGrid();
    }

    /**
     * 添加部门页
     *
     * @return
     */
    @RequestMapping("/addPage")
    public String addPage() {
        return "admin/organization/organizationAdd";
    }

    /**
     * 添加部门
     *
     * @param organization
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(@Valid Organization organization) {
        organization.setCreateTime(new Date());
        organizationService.insert(organization);
        return renderSuccess("添加成功！");
    }

    /**
     * 编辑部门页
     *
     * @param request
     * @param id
     * @return
     */
    @GetMapping("/editPage")
    public String editPage(Model model, Long id) {
        Organization organization = organizationService.selectById(id);
        model.addAttribute("organization", organization);
        return "admin/organization/organizationEdit";
    }

    /**
     * 编辑部门
     *
     * @param organization
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(@Valid Organization organization) {
        organizationService.updateById(organization);
        return renderSuccess("编辑成功！");
    }

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(Long id) {
        organizationService.deleteById(id);
        return renderSuccess("删除成功！");
    }
}