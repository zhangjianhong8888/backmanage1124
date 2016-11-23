package org.qydata.dao;


import org.qydata.entity.Customer;

import java.util.List;

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
    public boolean insertCustomer(Customer vo);
    /**
     * 添加新客户--测试
     * @param vo 包含了要添加数据的Customer类对象
     * @return 插入成功返回true,否则返回false;
     */
    public boolean insertCustomerTest(Customer vo);


    /**
     * 查询当前登录着可见的客户信息并分页显示
     * @param page 当前页第一条数据在表中的位置
     * @param rows 每页显示的记录数
     * @param adminId 当前登录者 Id
     * @return 如果有数据，则以List集合的形式返回，如果没有返回空（size==0）
     */
    public List<Customer> findCustomerByAdminId(Integer page,Integer rows,Integer adminId);





//    /**
//     * 获取总的数据量
//     * @return
//     */
//    public Integer getAllCount();
//
//    /**
//     * 根据Id修改客户信息
//     * @param vo 包含了要修改数据的Customer类对象
//     * @return 修改成功返回true,否则返回false;
//     */
//    public boolean updateCustomer(Customer vo);
//
//    /**
//     * 根据Id删除客户信息
//     * @param id 要删除客户的Id
//     * @return 删除成功返回true,否则返回false;
//     */
//    public boolean deleteCustomer(Integer id);



}
