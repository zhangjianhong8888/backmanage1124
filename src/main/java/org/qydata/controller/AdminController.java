package org.qydata.controller;

import org.qydata.entity.Admin;
import org.qydata.entity.AdminRoleInfo;
import org.qydata.entity.Dept;
import org.qydata.entity.Role;
import org.qydata.service.AdminService;
import org.qydata.vo.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2016/11/30.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    private Integer getLineSize(String lineSize){
        if(lineSize==null||lineSize.trim().isEmpty()||Integer.parseInt(lineSize)<=0){
            return 1;
        }
        return Integer.parseInt(lineSize);
    }

    @RequestMapping(value = "/addAdminView")
    public String addAdminView(Model model){

        try {
            List<Dept>  listDept = adminService.findAllDept();
            List<Role> listRole = adminService.findAllRole();
            model.addAttribute("listDept",listDept);
            model.addAttribute("listRole",listRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/admin/addAdmin";
    }

    @RequestMapping(value = "/addAdminAction")
    public String addAdminAction(AdminRoleInfo adminRoleInfo, RedirectAttributes model){
        try {
            boolean flag = adminService.addAdminAndRole(adminRoleInfo);
            if(!flag){
                model.addFlashAttribute("msg","添加失败");
                return "redirect:/admin/addAdminView";
            }
        } catch (Exception e) {
            model.addFlashAttribute("msg","添加失败!");
            return "redirect:/admin/addAdminView";
        }
        return "redirect:/admin/findAllAdmin";
    }

    @RequestMapping(value = "/findAllAdmin")
    public String findAllAdmin(HttpServletRequest request,Model model){
        PageModel<Admin> pageModel = new PageModel<Admin>();
        Map<String,Object> map = new HashMap<String,Object>();
        Integer lineSize = this.getLineSize(request.getParameter("lineSize"));//当前页
        Integer pageSize = 5;//每页显示条数
        pageModel.setCpage(lineSize);
        pageModel.setPageSize(pageSize);
        map.put("beginIndex",pageModel.getBeginIndex());
        map.put("line",pageModel.getPageSize());
        PageModel<Admin> pageModelA;
        List<Admin> list = null;
        Integer count = null;
        Integer totlePage = null;
        try {
            pageModelA = adminService.findAllAdmin(map);
            list =  pageModelA.getList();
            count = pageModelA.getRows();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count%pageSize==0){
            totlePage=(count/pageSize);
        }else{
            totlePage=(count/pageSize)+1;
        }
        model.addAttribute("count",count);
        model.addAttribute("adminList",list);
        model.addAttribute("totlePage",totlePage);
        model.addAttribute("lineSize",lineSize);
        return "/admin/adminList";
    }

    @RequestMapping(value = "/findAllByColumn")
    public String findAllByColumn(HttpServletRequest request,Model model,String content){
        PageModel<Admin> pageModel = new PageModel<Admin>();
        Map<String,Object> map = new HashMap<String,Object>();
        Integer lineSize = this.getLineSize(request.getParameter("lineSize"));//当前页
        Integer pageSize = 5;//每页显示条数
        pageModel.setCpage(lineSize);
        pageModel.setPageSize(pageSize);
        map.put("beginIndex",pageModel.getBeginIndex());
        map.put("line",pageModel.getPageSize());
        map.put("content",content);
        PageModel<Admin> pageModelA;
        List<Admin> list = null;
        Integer count = null;
        Integer totlePage = null;
        try {
            pageModelA = adminService.findAllByColumn(map);
            list =  pageModelA.getList();
            count = pageModelA.getRows();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count%pageSize==0){
            totlePage=(count/pageSize);
        }else{
            totlePage=(count/pageSize)+1;
        }
        model.addAttribute("content",content);
        model.addAttribute("count",count);
        model.addAttribute("adminList",list);
        model.addAttribute("totlePage",totlePage);
        model.addAttribute("lineSize",lineSize);
        return "/admin/adminListSerach";

    }

    @RequestMapping(value = "/statusStart/{loginName}")
    public String statusStart(@PathVariable String loginName){
        try {
            adminService.updateStatusStart(loginName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/findAllAdmin";
    }

    @RequestMapping(value = "/statusForbid/{loginName}")
    public String statusForbid(@PathVariable String loginName){
        try {
            adminService.updateStatusForbid(loginName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/findAllAdmin";
    }

}
