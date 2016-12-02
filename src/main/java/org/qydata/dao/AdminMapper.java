package org.qydata.dao;

import org.qydata.entity.Admin;
import org.qydata.entity.Dept;
import org.qydata.entity.Role;
import org.qydata.entity.RoleAdmin;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by jonhn on 2016/11/23.
 */
public interface AdminMapper{
    /**
     * 根据登录用户名查找是否有指定用户
     * @param loginName
     * @return
     */
    public Admin findById(String loginName) ;

    /**
     * 根据登录用户名匹配角色
     * @param loginName
     * @return
     */
    public Set<String> findAllRoleByAdmin(String loginName) ;

    /**
     * 根据登录用户名匹配权限
     * @param loginName
     * @return
     */
    public Set<String> findAllActionByAdmin(String loginName) ;

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
     * 添加管理员
     * @param admin
     * @return
     * @throws Exception
     */
    public boolean addAdmin(Admin admin)throws Exception;

    /**
     * 分配角色
     * @param roleAdmin
     * @return
     * @throws Exception
     */
    public boolean addRoleAdmin(RoleAdmin roleAdmin)throws Exception;

    /**
     * 查找全部管理员
     * @return
     * @throws Exception
     */
    public List<Admin> findAllAdmin(Map<String,Object> map)throws Exception;

    /**
     * 统计数据量
     * @return
     * @throws Exception
     */
    public Integer getAllCountAdmin()throws Exception;

    /**
     * 启动账号
     * @return
     * @throws Exception
     */
    public boolean updateStatusStart(String loginName)throws Exception;

    /**
     *禁用账号
     * @return
     * @throws Exception
     */
    public boolean updateStatusforbid(String loginName)throws Exception;

    /**
     * 模糊搜索
     * @param map
     * @return
     * @throws Exception
     */
    public List<Admin> findByColumn(Map<String,Object> map)throws Exception;

    /**
     * 模糊搜索总数据量
     * @param map
     * @return
     * @throws Exception
     */
    public Integer getCountColumn(Map<String,Object> map)throws Exception;

    /**
     * 根据用户名和旧密码修改密码
     * @param loginName
     * @param password
     * @return
     * @throws Exception
     */
    public boolean updatePassword(String loginName,String password,String newPassword)throws Exception;


}
