package org.qydata.service;

import org.qydata.entity.Admin;
import org.qydata.entity.AdminRoleInfo;
import org.qydata.entity.Dept;
import org.qydata.entity.Role;
import org.qydata.vo.PageModel;

import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2016/11/23.
 */

public interface AdminService {

    /**
     * 此方法是留给Realm进行用户认证使用的，目的是根据用户名取得密码数据
     * @param loginName
     * @return
     * @throws Exception
     */
    public Admin get(String loginName) throws Exception ;
    /**
     * 此方法是留给Realm实现授权处理的，主要要根据用户ID查询出所有的角色以及所有对应权限
     * @param loginName
     * @return 返回的数据包含有两个内容：<br>
     * <li>key = allRoles、value = 所有的用户角色；</li>
     * <li>key = allActions、value = 所有的用户权限。</li>
     * @throws Exception
     */
    public Map<String,Object> listAuthByAdmin(String loginName) throws Exception ;

    /**
     * 查询所有的角色
     * @return
     * @throws Exception
     */
    public List<Role> findAllRole()throws Exception;
    /**
     * 查找所有的部门
     * @return
     * @throws Exception
     */
    public List<Dept> findAllDept()throws Exception;

    /**
     * 添加管理员并分配角色
     * @param adminRoleInfo
     * @return
     * @throws Exception
     */
    public boolean addAdminAndRole(AdminRoleInfo adminRoleInfo)throws Exception;

    /**
     * 查找全部管理员并分页显示
     * @param map
     * @return
     * @throws Exception
     */
    public PageModel<Admin> findAllAdmin(Map<String,Object> map)throws Exception;

    public PageModel<Admin> findAllByColumn(Map<String,Object> map)throws Exception;

    public boolean updateStatusStart(String longinName)throws Exception;

    public boolean updateStatusForbid(String longinName)throws Exception;


}
