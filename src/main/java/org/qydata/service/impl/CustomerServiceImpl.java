package org.qydata.service.impl;


import org.qydata.dao.CustomerDeptAdminMapper;
import org.qydata.dao.CustomerMapper;
import org.qydata.entity.*;
import org.qydata.service.CustomerService;
import org.qydata.vo.ChangeIp;
import org.qydata.vo.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by jonhn on 2016/11/8.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerDeptAdminMapper customerDeptAdminMapper;

    @Override
    public Customer findByAuthId(String authId) {
        return customerMapper.findByAuthId(authId);
    }

    @Override
    public boolean insertCustomer(Map<String,Object> map) {
        Set<Map.Entry<String,Object>> set = map.entrySet();
        Iterator<Map.Entry<String,Object>> it = set.iterator();
        Customer customer = null;
        Admin admin = null;
        while(it.hasNext()){
            Map.Entry<String,Object> me = it.next();
            if(me.getKey().equals("allCustomer")){
                customer = (Customer) me.getValue();
            }if(me.getKey().equals("allAdmin") ){
                admin = (Admin)me.getValue();
            }
        }
        //向客户表中插入数据
        boolean flag = customerMapper.insertCustomer(customer);
        Customer customer1 = new Customer();
        customer1.setAuthId(customer.getAuthId()+"_test");
        customer1.setName(customer.getName());
        customerMapper.insertCustomerTest(customer1);
        //向部门客户映射表中插入数据
        CustomerDeptAdmin customerDeptAdmin1 = new CustomerDeptAdmin();
        customerDeptAdmin1.setCustomerId(customer.getId());
        customerDeptAdmin1.setDeptNo(admin.getDeptNo());
        customerDeptAdmin1.setAdminId(admin.getId());
        System.out.println(customer.getId());
        CustomerDeptAdmin customerDeptAdmin2 = new CustomerDeptAdmin();
        customerDeptAdmin2.setCustomerId(customer1.getId());
        customerDeptAdmin2.setDeptNo(admin.getDeptNo());
        customerDeptAdmin2.setAdminId(admin.getId());
        System.out.println(customer1.getId());
        customerDeptAdminMapper.insertCustomerDeptAdmin(customerDeptAdmin1);
        customerDeptAdminMapper.insertCustomerDeptAdminTest(customerDeptAdmin2);
        return flag;
    }

    @Override
    public PageModel<Customer> findCustomerByAdminId(Map<String,Object> map) {
        Set<Map.Entry<String,Object>> set = map.entrySet();
        Iterator<Map.Entry<String,Object>> it = set.iterator();
        PageModel<Customer> pageModel= null;
        Integer adminId= 0;
        while(it.hasNext()){
            Map.Entry<String,Object> me = it.next();
            if(me.getKey().equals("pageModel")){
                pageModel = (PageModel) me.getValue();
            }if(me.getKey().equals("adminId") ){
                adminId = (Integer) me.getValue();
            }
        }
        PageModel<Customer> pageModelA = new PageModel<Customer>();
        pageModelA.setRows(customerMapper.getAllCountByAdminId(adminId));
        pageModelA.setList(customerMapper.findCustomerByAdminId(pageModel.getBeginIndex(),pageModel.getPageSize(),adminId));
        return pageModelA;
    }

    @Override
    public boolean insertCustomerIp(String beginIp,String endIp,String customerId) {
        List<Long> listA = ChangeIp.spiltIpLong(beginIp);
        List<Long> listB = ChangeIp.spiltIpLong(endIp);
        List<String> listC = ChangeIp.spiltIp(beginIp);
        List<String> listD = ChangeIp.spiltIp(endIp);
        CustomerIp vo = new CustomerIp();
        boolean flag = false;
        for (int i=0;i<listA.size();i++){
            vo.setBeginIp(listA.get(i));
            vo.setEndIp(listB.get(i));
            vo.setBeginIpRaw(listC.get(i));
            vo.setEndIpRaw(listD.get(i));
            vo.setCustomerId(Integer.parseInt(customerId));
            flag = customerMapper.insertCustomerIp(vo);
        }
        return flag;
    }

    @Override
    public List<CustomerBalanceModifyReason> findAll() {
        return customerMapper.findAll();
    }


//    @Override
//    public PageModel<Customer> selectAll(PageModel<Customer> pageModel) {
//        PageModel<Customer> pageModela = new PageModel<Customer>();
//        pageModela.setRows(customerMapper.getAllCount()+"");
//        pageModela.setList(customerMapper.selectAllCustomer(pageModel.getBeginIndex(),pageModel.getPageSize()));
//        return pageModela;
//    }
//
//    @Override
//    public boolean addCustomer(Customer vo) {
//        if(customerMapper.findById(vo.getId())==null){
//            return customerMapper.insertCustomer(vo);
//        }
//        return false;
//    }
//
//    @Override
//    public boolean updateCustomer(Customer vo) {
//        return customerMapper.updateCustomer(vo);
//    }
//
//    @Override
//    public boolean deleteCustomer(Integer id) {
//        return customerMapper.deleteCustomer(id);
//    }
//
//    @Override
//    public Customer findById(Customer vo) {
//        return customerMapper.findById(vo.getId());
//    }


}
