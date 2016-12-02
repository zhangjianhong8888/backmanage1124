package org.qydata.controller;

import org.apache.log4j.Logger;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2016/11/8.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final Logger log = Logger.getLogger(this.getClass());

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
    @RequestMapping(value = ("/addCustomerAction"))
    public String addCustomerAction(){
        return "customer/addCustomer";
    }
    //一级管理员
    @RequestMapping(value = ("/insertCustomerOne"))
    public String insertCustomerOne(HttpServletRequest request,Customer vo,RedirectAttributes model){
        Admin admin = (Admin)request.getSession().getAttribute("adminInfo");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("allCustomer",vo);
        map.put("allAdmin",admin);
        try{
            boolean flag = customerService.insertCustomer(map);
            if (!flag) {
                model.addFlashAttribute("msg", "添加失败");
                return "redirect:/customer/addCustomerAction";
            }
        }catch (Exception e){
            e.printStackTrace();
            model.addFlashAttribute("msg", "添加失败！");
            return "redirect:/customer/addCustomerAction";
        }
        return "redirect:/customer/findAllCustomerOne";
    }
    //二级级管理员
    @RequestMapping(value = ("/insertCustomerTwo"))
    public String insertCustomerTwo(HttpServletRequest request,Customer vo,RedirectAttributes model){
        Admin admin = (Admin)request.getSession().getAttribute("adminInfo");
        Map<String,Object> map = new HashMap<String,Object>();
        System.out.println(vo);
        map.put("allCustomer",vo);
        map.put("allAdmin",admin);
        try{
            boolean flag = customerService.insertCustomer(map);
            if (!flag) {
                model.addFlashAttribute("msg", "添加失败!");
                return "redirect:/customer/addCustomerAction";
            }
        }catch (Exception e){
            model.addFlashAttribute("msg", "添加失败！");
            return "redirect:/customer/addCustomerAction";
        }
        return "redirect:/customer/findAllCustomerTwo";
    }
    //三级级管理员
    @RequestMapping(value = ("/insertCustomerThree"))
    public String insertCustomerThree(HttpServletRequest request,Customer vo,RedirectAttributes model){
        Admin admin = (Admin)request.getSession().getAttribute("adminInfo");
        Map<String,Object> map = new HashMap<String,Object>();
        System.out.println(vo);
        map.put("allCustomer",vo);
        map.put("allAdmin",admin);
        try{
            boolean flag = customerService.insertCustomer(map);
            if (!flag) {
                model.addFlashAttribute("msg", "添加失败");
                return "redirect:/customer/addCustomerAction";
            }
        }catch (Exception e){
            model.addFlashAttribute("msg", "添加失败!");
            return "redirect:/customer/addCustomerAction";
        }
        return "redirect:/customer/findAllCustomerThree";
    }

    //添加Ip
    @RequestMapping("/addCustomerIpAction/{id}")
    public String addCustomerIpAction(@PathVariable("id") String id,Model model){
        model.addAttribute(id);
        return "customer/addCustomerIp";
    }
    @RequestMapping(value = "/insertCustomerIp")
    public String insertCustomerIp(String beginIp, String endIp, String customerId, RedirectAttributes model){
        try {
            boolean flag = customerService.insertCustomerIp(beginIp, endIp, customerId);
            if (!flag) {
                model.addFlashAttribute("msg", "添加失败");
                return "redirect:/customer/addCustomerIpAction/"+customerId;
            }
        }catch (Exception e){
            model.addFlashAttribute("msg", "添加失败");
            return "redirect:/customer/addCustomerIpAction/"+customerId;
        }
        return "redirect:/customer/customerIpListAction/"+customerId;
    }
    //根据客户Id查看所有Ip
    @RequestMapping(value = "/customerIpListAction/{customerId}")
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
    //删除客户Ip
    @RequestMapping(value = "/deleteIp/{id}/{customerId}")
    public String deleteIp(@PathVariable("id") String id,@PathVariable("customerId") String customerId){
        try {
            boolean flag = customerService.deleteIpById(Integer.parseInt(id));
        }catch (Exception e){

        }
        return "redirect:/customer/customerIpListAction/" + customerId;
    }

    //余额变动日志
    @RequestMapping(value = "/addCustomerBalanceLogView")
    public  String addCustomerBalanceLogView(Model model){
       List<CustomerBalanceModifyReason> list= customerService.findAll();
       model.addAttribute("customerBalanceModifyReasonList",list);
        return "/customer/addCustomerBalanceLog";
    }
    //一级管理员
    @RequestMapping(value = "/addCustomerBalanceLogActionOne")
    public String addCustomerBalanceLogActionOne(String authId, String amount,String reasonId,RedirectAttributes Model){
        try {
            boolean flag = customerBalanceLogService.changeCustomerBalanceLog(authId, amount, reasonId);
            if (!flag) {
                Model.addFlashAttribute("msg","添加失败");
                return "redirect:/customer/addCustomerBalanceLogView";
            }
        }catch (Exception e){
            Model.addFlashAttribute("msg","添加失败");
            return "redirect:/customer/addCustomerBalanceLogView";
        }
        return "redirect:/customer/findAllCustomerOne";
    }
    //二级管理员
    @RequestMapping(value = "/addCustomerBalanceLogActionTwo")
    public String addCustomerBalanceLogActionTwo(String authId, String amount,String reasonId,RedirectAttributes Model){
        try {
            boolean flag = customerBalanceLogService.changeCustomerBalanceLog(authId, amount, reasonId);
            if (!flag) {
                Model.addFlashAttribute("msg","添加失败");
                return "redirect:/customer/addCustomerBalanceLogView";
            }
        }catch (Exception e){
            Model.addFlashAttribute("msg","添加失败");
            return "redirect:/customer/addCustomerBalanceLogView";
        }
        return "redirect:/customer/findAllCustomerTwo";
    }
    //三级管理员
    @RequestMapping(value = "/addCustomerBalanceLogActionThree")
    public String addCustomerBalanceLogActionThree(String authId, String amount,String reasonId,RedirectAttributes Model){
        try {
            boolean flag = customerBalanceLogService.changeCustomerBalanceLog(authId, amount, reasonId);
            if (!flag) {
                Model.addFlashAttribute("msg","添加失败");
                return "redirect:/customer/addCustomerBalanceLogView";
            }
        }catch (Exception e){
            Model.addFlashAttribute("msg","添加失败");
            return "redirect:/customer/addCustomerBalanceLogView";
        }
        return "redirect:/customer/findAllCustomerThree";
    }



    //添加CustomerApi
    @RequestMapping(value = "/addCustomerApiView/{customerId}")
    public String addCustomerApiView(@PathVariable("customerId") String customerId,Model model){
        List<Api> list = customerApiService.findAllApi();
        model.addAttribute(customerId);
        model.addAttribute("apiList",list);
        return "/customer/addCustomerApi";
    }
    @RequestMapping(value = "/addCustomerApiAction")
    public String addCustomerApiAction(RedirectAttributes model,String price, String customerId, String apiId, String enabled){
        try {
            boolean flag = customerApiService.insertCustomerApi(price, customerId, apiId, enabled);
            if (!flag) {
                model.addFlashAttribute("msg","添加失败");
                return "redirect:/customer/addCustomerApiView/"+customerId;
            }
        }catch (Exception e){
            model.addFlashAttribute("msg","添加失败");
            return "redirect:/customer/addCustomerApiView/"+customerId;
        }
        return "redirect:/customer/findAllCustomerApiList/"+customerId;
    }
    //根据客户Id查看所对应的的所有Api
    @RequestMapping(value = "/findAllCustomerApiList/{customerId}")
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

    //根据id查找指定的customerApi
    @RequestMapping(value = "/findCustomerApiById/{id}")
    public String findCustomerApiById(@PathVariable("id") String id,Model model){
        List<Api> list = customerApiService.findAllApi();
        CustomerApi customerApi = customerApiService.findById(Integer.parseInt(id));
        model.addAttribute("apiList",list);
        model.addAttribute(customerApi);
        return "/customer/updateCustomerApi";
    }

    //根据id修改指定的customerApi
    @RequestMapping(value = "/updateCustomerApiById")
    public String updateCustomerApiById(String id,String customerId,String price,String apiId,String enabled,RedirectAttributes model ){
       CustomerApi customerApi = new CustomerApi();
        customerApi.setId(Integer.parseInt(id));
        customerApi.setCustomerId(Integer.parseInt(customerId));
        customerApi.setPrice(Integer.parseInt(price.trim().replaceAll(",","")));
        customerApi.setApiId(Integer.parseInt(apiId));
        customerApi.setEnabled(Boolean.parseBoolean(enabled));
        try {
            boolean flag = customerApiService.updateCustomerApiById(customerApi);
            if (!flag) {
                model.addFlashAttribute("msg","修改失败");
                return "redirect:/customer/findCustomerApiById/"+customerApi.getId();
            }
        }catch (Exception e){
            model.addFlashAttribute("msg","修改失败");
            return "redirect:/customer/findCustomerApiById/"+customerApi.getId();
        }
        return "redirect:/customer/findAllCustomerApiList/" + customerApi.getCustomerId();
    }


/**
     *一级模糊搜索
     * @return
     */
    @RequestMapping(value = "/findByCustomerInfoByColumnOne")
    public String findByCustomerInfoByColumnOne(String content,HttpServletRequest request,Model model){
        Admin admin = (Admin)request.getSession().getAttribute("adminInfo");
        PageModel<Customer> pageModel = new PageModel();
        Integer lineSize = this.getLineSize(request.getParameter("lineSize"));//当前页
        Integer pageSize = 5;//每页显示条数
        pageModel.setCpage(lineSize);
        pageModel.setPageSize(pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("beginIndex",pageModel.getBeginIndex());
        map.put("line",pageModel.getPageSize());
        map.put("content",content);
        PageModel<Customer> pageModelA = customerService.findCustomerInfoByColumn(map);
        List<Customer> list = pageModelA.getList();
        Integer count = pageModelA.getRows();
        Integer totlePage = 0;
        if(count%pageSize==0){
            totlePage=(count/pageSize);
        }else{
            totlePage=(count/pageSize)+1;
        }
        model.addAttribute("content",content);
        model.addAttribute("count",count);
        model.addAttribute("customerList",list);
        model.addAttribute("totlePage",totlePage);
        model.addAttribute("lineSize",lineSize);
        return "/customer/customerListSearch";
    }
/**
     * 二级模糊搜索
     * @param content
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/findByCustomerInfoByColumnTwo")
    public String findByCustomerInfoByColumnTwo(String content,HttpServletRequest request,Model model){
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
        map.put("content",content);
        PageModel<Customer> pageModelA = customerService.findCustomerInfoByColumn(map);
        List<Customer> list = pageModelA.getList();
        Integer count = pageModelA.getRows();
        Integer totlePage = 0;
        if(count%pageSize==0){
            totlePage=(count/pageSize);
        }else{
            totlePage=(count/pageSize)+1;
        }
        model.addAttribute("content",content);
        model.addAttribute("count",count);
        model.addAttribute("customerList",list);
        model.addAttribute("totlePage",totlePage);
        model.addAttribute("lineSize",lineSize);
        return "/customer/customerListSearch";
    }
/**
     * 三级模糊搜索
     * @param content
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/findByCustomerInfoByColumnThree")
    public String findByCustomerInfoByColumnThree(String content,HttpServletRequest request,Model model){
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
        map.put("content",content);
        PageModel<Customer> pageModelA = customerService.findCustomerInfoByColumn(map);
        List<Customer> list = pageModelA.getList();
        Integer count = pageModelA.getRows();
        Integer totlePage = 0;
        if(count%pageSize==0){
            totlePage=(count/pageSize);
        }else{
            totlePage=(count/pageSize)+1;
        }
        model.addAttribute("content",content);
        model.addAttribute("count",count);
        model.addAttribute("customerList",list);
        model.addAttribute("totlePage",totlePage);
        model.addAttribute("lineSize",lineSize);
        return "/customer/customerListSearch";
    }


}
