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
    public boolean insertCustomer(Map<String,Object> map)throws Exception {
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
            Customer customerA = new Customer();
            customerA.setName(customer.getName().trim());
            customerA.setAuthId(customer.getAuthId().trim());
            customerMapper.insertCustomer(customerA);
            Customer customerB = new Customer();
            customerB.setAuthId(customer.getAuthId().trim() + "_test");
            customerB.setName(customer.getName().trim());
            customerMapper.insertCustomerTest(customerB);
            //向部门客户映射表中插入数据
            CustomerDeptAdmin customerDeptAdmin1 = new CustomerDeptAdmin();
            customerDeptAdmin1.setCustomerId(customerA.getId());
            customerDeptAdmin1.setDeptNo(admin.getDeptNo());
            customerDeptAdmin1.setAdminId(admin.getId());
            CustomerDeptAdmin customerDeptAdmin2 = new CustomerDeptAdmin();
            customerDeptAdmin2.setCustomerId(customerB.getId());
            customerDeptAdmin2.setDeptNo(admin.getDeptNo());
            customerDeptAdmin2.setAdminId(admin.getId());
            customerDeptAdminMapper.insertCustomerDeptAdmin(customerDeptAdmin1);
            return customerDeptAdminMapper.insertCustomerDeptAdminTest(customerDeptAdmin2);
    }

    @Override
    public PageModel<Customer> findAllCustomer(Map<String,Object> map) {
        PageModel<Customer> pageModel = new PageModel<Customer>();
        pageModel.setRows(customerMapper.getAllCount(map));
        pageModel.setList(customerMapper.findAllCustomer(map));
        return pageModel;
    }

    @Override
    public boolean insertCustomerIp(String beginIp,String endIp,String customerId) throws Exception{
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

    @Override
    public PageModel<CustomerIp> findAllIpByCustomerId(Map<String, Object> map) {
        PageModel<CustomerIp> pageModel = new PageModel<CustomerIp>();
        pageModel.setRows(customerMapper.getAllCountByCustomerId(map));
        pageModel.setList(customerMapper.findAllIpByCustomerId(map));
        return pageModel;
    }

    @Override
    public boolean deleteIpById(Integer id)throws Exception {
        return customerMapper.deleteIpById(id);
    }

    @Override
    public PageModel<Customer> findCustomerInfoByColumn(Map<String, Object> map) {
        PageModel<Customer> pageModel = new PageModel<Customer>();
        pageModel.setRows(customerMapper.getAllCountByColumn(map));
        pageModel.setList(customerMapper.findCustomerInfoByColumn(map));
        return pageModel;
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
