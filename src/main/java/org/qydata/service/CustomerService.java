package org.qydata.service;


import org.qydata.entity.Customer;
import org.qydata.entity.CustomerBalanceModifyReason;
import org.qydata.entity.CustomerIp;
import org.qydata.vo.PageModel;

import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2016/11/8.
 */
public interface CustomerService {

    /**
     * 根据authId查找客户信息
     * @param authId 要查找客户的authId
     * @return 如果有数据，则数据以Customer对象的形式返回，如果没有返回空；
     */
    public Customer findByAuthId(String authId);

    /**
     * 添加新客户
     * @param map 包含了要添加的数据
     * @return 插入成功返回true,否则返回false;
     */
    public boolean insertCustomer(Map<String,Object> map)throws Exception ;
    /**
     * 查询当前登录着可见的客户信息并分页显示
     * @map 包含了要使用的数据
     * @return 如果有数据，则以List集合的形式返回，如果没有返回空（size==0）
     */
    public PageModel<Customer> findAllCustomer(Map<String,Object> map);

    /**
     * 插入Ip
     * @param beginIp
     * @param endIp
     * @param customerId
     * @return
     */
    public boolean insertCustomerIp(String beginIp,String endIp,String customerId)throws Exception;
    /**
     * 查询全部的CustomerBalanceModifyReason
     * @return
     */
    public List<CustomerBalanceModifyReason> findAll();

    /**
     * 查询客户Ip,并分页显示
     * @param map
     * @return
     */
    public PageModel<CustomerIp> findAllIpByCustomerId(Map<String,Object> map);
    /**
     * 根据Id删除Ip
     * @param id
     * @return
     */
    public boolean deleteIpById(Integer id)throws Exception;

    public PageModel<Customer> findCustomerInfoByColumn(Map<String,Object> map);


//    /**
//     * 查询所有客户信息
//     * @param pageModel
//     * @return 如果有数据，则以Map集合的形式返回，如果没有返回空（size==0）
//     */
//    public PageModel<Customer> selectAll(PageModel<Customer> pageModel);
//
//    /**
//     * 添加新客户，该操作会调用数据层CustomerMapper接口的两个方法<br>
//     *     <li>第一个方法：findById()，判断要添加的客户信息是否已存在，如果返回null，则可以添加</li>
//     *     <li>第二个方法：insertCustomer()，实现数据添加</li>
//     * @param vo 包含了要添加数据的Customer类对象
//     * @return 添加成功返回true,否则返回false
//     */
//    public boolean addCustomer(Customer vo);
//
//    /**
//     * 根据Id修改客户信息
//     * @param vo 包含了要修改数据的Customer类对象
//     * @return 修改成功返回true,否则返回false;
//     */
//    public boolean updateCustomer(Customer vo);
//    /**
//     * 根据Id删除客户信息
//     * @param id 要删除客户的Id
//     * @return 删除成功返回true,否则返回false;
//     */
//    public boolean deleteCustomer(Integer id);
//
//
}
