package org.qydata.controller;

import org.qydata.entity.Admin;
import org.qydata.entity.Customer;
import org.qydata.service.CustomerService;
import org.qydata.vo.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    //客户列表
    @RequestMapping(value = ("/findCustomerByAdminId"),method = GET)
    public String findCustomerByAdminId(HttpServletRequest request, Model model){
        Admin admin = (Admin)request.getSession().getAttribute("adminInfo");
        PageModel<Customer> pageModel = new PageModel();
        pageModel.setCpage(1);
        pageModel.setPageSize(5);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pageModel",pageModel);
        map.put("adminId",admin.getId());
        PageModel<Customer> pageModelA = customerService.findCustomerByAdminId(map);
        List<Customer> list = pageModelA.getList();
        Integer count = pageModelA.getRows();
        model.addAttribute("customerList",list);
        model.addAttribute(count);
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
        return "redirect:/customer/customerList";
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
