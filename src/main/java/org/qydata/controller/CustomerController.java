package org.qydata.controller;

import org.qydata.entity.*;
import org.qydata.service.CustomerApiService;
import org.qydata.service.CustomerBalanceLogService;
import org.qydata.service.CustomerService;
import org.qydata.vo.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
    @Autowired
    private CustomerBalanceLogService customerBalanceLogService;
    @Autowired
    private CustomerApiService customerApiService;


    private Integer getLineSize(String lineSize){
        if(lineSize==null||lineSize.trim().isEmpty()||Integer.parseInt(lineSize)<=0){
            return 1;
        }
        return Integer.parseInt(lineSize);
    }
    //三级管理员可见客户列表
    @RequestMapping(value = ("/findAllCustomerThree"))
    public String findAllCustomerThree(HttpServletRequest request,Model model){
        Admin admin = (Admin)request.getSession().getAttribute("adminInfo");
        PageModel<Customer> pageModel = new PageModel();
        Integer lineSize = this.getLineSize(request.getParameter("lineSize"));//当前页
        Integer pageSize = 5;//每页显示条数
        pageModel.setCpage(lineSize);
        pageModel.setPageSize(pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("beginIndex",pageModel.getBeginIndex());
        map.put("line",pageModel.getPageSize());
        map.put("adminId",admin.getId());
        PageModel<Customer> pageModelA = customerService.findAllCustomer(map);
        List<Customer> list = pageModelA.getList();
        Integer count = pageModelA.getRows();
        Integer totlePage = 0;
        if(count%pageSize==0){
            totlePage=(count/pageSize);
        }else{
            totlePage=(count/pageSize)+1;
        }
        model.addAttribute("count",count);
        model.addAttribute("customerList",list);
        model.addAttribute("totlePage",totlePage);
        model.addAttribute("lineSize",lineSize);
        return "/customer/customerList";
    }
    //二级管理员可见客户列表
    @RequestMapping(value = ("/findAllCustomerTwo"))
    public String findAllCustomerTwo(HttpServletRequest request,Model model){
        Admin admin = (Admin)request.getSession().getAttribute("adminInfo");
        PageModel<Customer> pageModel = new PageModel();
        Integer lineSize = this.getLineSize(request.getParameter("lineSize"));//当前页
        Integer pageSize = 5;//每页显示条数
        pageModel.setCpage(lineSize);
        pageModel.setPageSize(pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("beginIndex",pageModel.getBeginIndex());
        map.put("line",pageModel.getPageSize());
        map.put("deptNo",admin.getDeptNo());
        PageModel<Customer> pageModelA = customerService.findAllCustomer(map);
        List<Customer> list = pageModelA.getList();
        Integer count = pageModelA.getRows();
        Integer totlePage = 0;
        if(count%pageSize==0){
            totlePage=(count/pageSize);
        }else{
            totlePage=(count/pageSize)+1;
        }
        model.addAttribute("count",count);
        model.addAttribute("customerList",list);
        model.addAttribute("totlePage",totlePage);
        model.addAttribute("lineSize",lineSize);
        return "/customer/customerList";
    }
    //一级管理员可见客户列表
    @RequestMapping(value = ("/findAllCustomerOne"))
    public String findAllCustomerOne(HttpServletRequest request,Model model){
        Admin admin = (Admin)request.getSession().getAttribute("adminInfo");
        PageModel<Customer> pageModel = new PageModel();
        Integer lineSize = this.getLineSize(request.getParameter("lineSize"));//当前页
        Integer pageSize = 5;//每页显示条数
        pageModel.setCpage(lineSize);
        pageModel.setPageSize(pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("beginIndex",pageModel.getBeginIndex());
        map.put("line",pageModel.getPageSize());
        PageModel<Customer> pageModelA = customerService.findAllCustomer(map);
        List<Customer> list = pageModelA.getList();
        Integer count = pageModelA.getRows();
        Integer totlePage = 0;
        if(count%pageSize==0){
            totlePage=(count/pageSize);
        }else{
            totlePage=(count/pageSize)+1;
        }
        model.addAttribute("count",count);
        model.addAttribute("customerList",list);
        model.addAttribute("totlePage",totlePage);
        model.addAttribute("lineSize",lineSize);
        return "/customer/customerList";
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

    /**
     * 添加Ip
     * @param id
     * @param model
     * @return
     */
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

    /**
     * 余额变动日志
     * @param model
     * @return
     */
    @RequestMapping(value = "/addCustomerBalanceLogAction",method = GET)
    public  String addCustomerBalanceLogAction(Model model){
       List<CustomerBalanceModifyReason> list= customerService.findAll();
       model.addAttribute("customerBalanceModifyReasonList",list);
        return "/customer/addCustomerBalanceLog";
    }
    @RequestMapping(value = "/addCustomerBalanceLog",method = POST)
    public String addCustomerBalanceLog(String authId, String amount,String reasonId){
        System.out.println(authId);
        System.out.println(amount);
        System.out.println(reasonId);
       boolean flag = customerBalanceLogService.insertcustomerBalanceLog(authId,amount,reasonId);
       if(flag){
           return "redirect:/customer/findCustomerByAdminId";
       }
        return "/customer/addCustomerBalanceLogAction";
    }
    /**
     * 添加新客户时验证账户名是否已存在
     * @param authId
     * @param response
     */
    @RequestMapping(value = "/findCustomerByAuthId/{authId}")
    public void findCustomerByAuthIdAdd(@PathVariable("authId") String authId,HttpServletResponse response){
        Customer customer = customerService.findByAuthId(authId);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if(customer!=null){
                out.print("yes");
            }else{
                out.print("no");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //添加CustomerApi
    @RequestMapping(value = "/addCustomerApiAction/{customerId}",method = GET)
    public String addCustomerApiAction(@PathVariable("customerId") String customerId,Model model){
        List<Api> list = customerApiService.findAllApi();
        model.addAttribute(customerId);
        model.addAttribute("apiList",list);
        return "/customer/addCustomerApi";
    }
    @RequestMapping(value = "/addCustomerApi",method = POST)
    public String addCustomerApi(String price, String customerId, String apiId, String enabled){
        boolean flag = customerApiService.insertCustomerApi(price,customerId,apiId,enabled);
        if(flag){
            return "redirect:/customer/findCustomerByAdminId";
        }
        return "";
    }
    //根据客户Id查看所对应的的所有Api
    @RequestMapping(value = "/findAllCustomerApiList/{customerId}",method = GET)
    public String findAllCustomerApiList(HttpServletRequest request,@PathVariable("customerId") String customerId,Model model){
        PageModel<CustomerIp> pageModel = new PageModel<CustomerIp>();
        Integer lineSize = this.getLineSize(request.getParameter("lineSize"));//当前页
        Integer pageSize = 5;//每页显示条数
        pageModel.setCpage(lineSize);
        pageModel.setPageSize(pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("beginIndex",pageModel.getBeginIndex());
        map.put("line",pageModel.getPageSize());
        map.put("customerId",Integer.parseInt(customerId));
        PageModel<CustomerApi> pageModelA = customerApiService.findAllByCustomerId(map);
        List<CustomerApi> list = pageModelA.getList();
        Integer count = pageModelA.getRows();
        Integer totlePage = null;
        if(count%pageSize==0){
            totlePage=(count/pageSize);
        }else{
            totlePage=(count/pageSize)+1;
        }
        model.addAttribute("count",count);
        model.addAttribute("customerId",customerId);
        model.addAttribute("customerApiList",list);
        model.addAttribute("totlePage",totlePage);
        model.addAttribute("lineSize",lineSize);

        return "/customer/customerApiList";
    }

    @RequestMapping(value = "/findCustomerApiById/{id}")
    public String findCustomerApiById(@PathVariable("id") String id,Model model){
        List<Api> list = customerApiService.findAllApi();
        CustomerApi customerApi = customerApiService.findById(Integer.parseInt(id));
        model.addAttribute("apiList",list);
        model.addAttribute(customerApi);
        return "/customer/updateCustomerApi";
    }

    @RequestMapping(value = "/updateCustomerApiById/{customerId}",method = POST)
    public String updateCustomerApiById(CustomerApi customerApi,@PathVariable("customerId") String customerId){
       boolean flag = customerApiService.updateCustomerApiById(customerApi);
       if (flag){
           return "redirect:/customer/findAllCustomerApiList/"+customerId;
       }
        return "";
    }
    //根据客户Id查看所有Ip
    @RequestMapping(value = "/customerIpListAction/{customerId}",method = GET)
    public String customerIpListAction(HttpServletRequest request,Model model,@PathVariable("customerId") String customerId){
        PageModel<CustomerIp> pageModel = new PageModel<CustomerIp>();
        Integer lineSize = this.getLineSize(request.getParameter("lineSize"));//当前页
        Integer pageSize = 5;//每页显示条数
        pageModel.setCpage(lineSize);
        pageModel.setPageSize(pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("beginIndex",pageModel.getBeginIndex());
        map.put("line",pageModel.getPageSize());
        map.put("customerId",Integer.parseInt(customerId));
        PageModel<CustomerIp> pageModelA = customerService.findAllIpByCustomerId(map);
        List<CustomerIp> list = pageModelA.getList();
        Integer count = pageModelA.getRows();
        Integer totlePage = null;
        if(count%pageSize==0){
            totlePage=(count/pageSize);
        }else{
            totlePage=(count/pageSize)+1;
        }
        model.addAttribute("count",count);
        model.addAttribute("customerId",customerId);
        model.addAttribute("customerIpList",list);
        model.addAttribute("totlePage",totlePage);
        model.addAttribute("lineSize",lineSize);
        return "customer/customerIpList";
    }

    /**
     * 删除客户Ip
     * @param id
     * @param customerId
     * @return
     */
    @RequestMapping(value = "/deleteIp/{id}/{customerId}")
    public String deleteIp(@PathVariable("id") String id,@PathVariable("customerId") String customerId){
        boolean flag = customerService.deleteIpById(Integer.parseInt(id));
        return "redirect:/customer/customerIpListAction/"+customerId;
    }
    @RequestMapping(value = "/aaaa")
    @ResponseBody
    public String aaaa(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("authId","bjsyqh");
        map.put("amount",100);
        System.out.println(customerService.updateBalanceByAuthId(map));
        return "asdf";
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
