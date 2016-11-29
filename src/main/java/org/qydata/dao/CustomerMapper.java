package org.qydata.dao;


import org.qydata.entity.Customer;
import org.qydata.entity.CustomerBalanceModifyReason;
import org.qydata.entity.CustomerIp;

import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2016/11/8.
 */
public interface CustomerMapper {

    /**
     * 根据authId查找客户信息
     * @param authId 要查找客户的authId
     * @return 如果有数据，则数据以Customer对象的形式返回，如果没有返回空；
     */
    public Customer findByAuthId(String authId);
    /**
     * 添加新客户--真实
     * @param vo 包含了要添加数据的Customer类对象
     * @return 插入成功返回true,否则返回false;
     */
    public boolean insertCustomer(Customer vo)throws Exception;
    /**
     * 添加新客户--测试
     * @param vo 包含了要添加数据的Customer类对象
     * @return 插入成功返回true,否则返回false;
     */
    public boolean insertCustomerTest(Customer vo)throws Exception;


    /**
     * 查询当前登录着可见的客户信息并分页显示
     * @param map 包含了筛选条件数据
     * @return 如果有数据，则以List集合的形式返回，如果没有返回空（size==0）
     */
    public List<Customer> findAllCustomer(Map<String,Object> map);
    /**
     * 获取总的数据量
     * @param map 包含了筛选条件数据
     * @return
     */
    public Integer getAllCount(Map<String,Object> map);

    /**
     * 插入Ip
     * @param customerIp
     * @return
     */
    public boolean insertCustomerIp(CustomerIp customerIp)throws Exception;

    /**
     * 查询全部的CustomerBalanceModifyReason
     * @return
     */
    public List<CustomerBalanceModifyReason> findAll();

    /**
     * 查询客户Ip
     * @param map
     * @return
     */
    public List<CustomerIp> findAllIpByCustomerId(Map<String,Object> map);

    /**
     * 根据客户Id获取总数据量
     * @param map
     * @return
     */
    public Integer getAllCountByCustomerId(Map<String,Object> map);

    /**
     * 根据Id删除Ip
     * @param id
     * @return
     */
    public boolean deleteIpById(Integer id)throws Exception;

    /**
     * 根据账户查询余额
     * @param authId
     * @return
     */
    public Long findBalanceByAuthId(String authId);
    /**
     * 根据账户修改余额
     * @param totle
     * @param authId
     * @return
     */
    public boolean updateBalanceByAuthId(Long totle,String authId)throws Exception;

    /**
     * 根据字段模糊搜索
     * @param map
     * @return
     */
    public List<Customer> findCustomerInfoByColumn(Map<String,Object> map);

    /**
     *根据字段模糊统计总数据量
     * @param map
     * @return
     */
    public Integer getAllCountByColumn(Map<String,Object> map);







}
