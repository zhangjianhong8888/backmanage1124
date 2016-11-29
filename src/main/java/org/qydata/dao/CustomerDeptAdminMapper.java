package org.qydata.dao;

import org.qydata.entity.CustomerDeptAdmin;

/**
 * Created by jonhn on 2016/11/22.
 */
public interface CustomerDeptAdminMapper {
    /**真实/测试
     * 向CustomerDept表中添加一条数据，实现部门表和客户表的映射
     * @param vo 包含了要添加的数据
     * @return 添加成功返回true，否则返回false
     */
    public boolean insertCustomerDeptAdmin(CustomerDeptAdmin vo)throws Exception;
    /**测试
     * 向CustomerDept表中添加一条数据，实现部门表和客户表的映射
     * @param vo 包含了要添加的数据
     * @return 添加成功返回true，否则返回false
     */
    public boolean insertCustomerDeptAdminTest(CustomerDeptAdmin vo)throws Exception;
}
