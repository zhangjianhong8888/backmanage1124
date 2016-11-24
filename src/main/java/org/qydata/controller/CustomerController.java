package org.qydata.controller;

import org.qydata.entity.Admin;
import org.qydata.entity.Customer;
import org.qydata.service.CustomerService;
import org.qydata.vo.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by jonhn on 2016/11/8.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    private Integer getLineSize(String lineSize){
        if(lineSize==null||lineSize.trim().isEmpty()||Integer.parseInt(lineSize)<=0){
            return 1;
        }
        return Integer.parseInt(lineSize);
    }
    //客户列表
    @RequestMapping(value = ("/findCustomerByAdminId"),method = GET)
    public String findCustomerByAdminId(HttpServletRequest request,Model model){
        Admin admin = (Admin)request.getSession().getAttribute("adminInfo");
        PageModel<Customer> pageModel = new PageModel();
        Integer lineSize = this.getLineSize(request.getParameter("lineSize"));//当前页
        Integer pageSize = 5;//每页显示条数
        pageModel.setCpage(lineSize);
        pageModel.setPageSize(pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pageModel",pageModel);
        map.put("adminId",admin.getId());
        PageModel<Customer> pageModelA = customerService.findCustomerByAdminId(map);
        List<Customer> list = pageModelA.getList();
        Integer count = pageModelA.getRows();
        Integer totlePage = 0;
        if(count%pageSize==0){
            totlePage=(count/pageSize);
        }else{
            totlePage=(count/pageSize)+1;
        }
        model.addAttribute("customerList",list);
        model.addAttribute("totlePage",totlePage);
        model.addAttribute("lineSize",lineSize);
        return "customer/customerList";
    }
    //新增客户
    @RequestMapping(value = ("/addCustomer"),method = GET)
    public String addCustomer(){
        return "customer/addCustomer";
    }
    @RequestMapping(value = ("/insertCustomer"),method = POST)
    public String insertCustomer(HttpServletRequest request,Customer vo){
        Admin admin = (Admin)request.getSession().getAttribute("adminInfo");
        Map<String,Object> map = new HashMap<String,Object>();
        System.out.println(vo);
        map.put("allCustomer",vo);
        map.put("allAdmin",admin);
        boolean flag = customerService.insertCustomer(map);
        if (!flag){
            return "/customer/addCustomer";
        }
        return "redirect:/customer/findCustomerByAdminId";
    }
    @RequestMapping("/addCustomerIp/{id}")
    public String addCustomerIp(@PathVariable("id") String id,Model model){
        model.addAttribute(id);
        return "customer/addCustomerIp";
    }

    @RequestMapping(value = "/insertCustomerIp",method = POST)
    public String insertCustomerIp(String beginIp,String endIp,String customerId){
        customerService.insertCustomerIp(beginIp,endIp,customerId);
        return "redirect:/customer/findCustomerByAdminId";
    }
    @RequestMapping(value = "/addCustomerBalanceLog")
    public  String addCustomerBalanceLog(){
        return "/customer/addCustomerBalanceLog";
    }
































    @RequestMapping(value = ("/addAdmin"),method = GET)
    public String addAdmin(){
        return "customer/addAdmin";
    }


//    @RequestMapping(value = ("/selectAll"))
//    public String selectAll(Model model, HttpServletResponse response){
//        PageModel<Customer> pageModel = new PageModel();
//        pageModel.setCpage("2");
//        pageModel.setPageSize("5");
//        PageModel<Customer> pageModela = customerService.selectAll(pageModel);
//        Integer count = pageModela.getRows();
//        List<Customer> list = pageModela.getList();
//
//
//        System.out.println(count);
//
//        model.addAttribute("customerlist",list);
//        return "test/testcustomerlist";
//    }
//    @RequestMapping("/delete/{id}")
//    public String delete(@PathVariable Integer id){
//        customerService.deleteCustomer(id);
//        return "/customer/selectAll";
//    }

}
