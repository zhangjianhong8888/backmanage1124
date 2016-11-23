package org.qydata.dao;

import org.qydata.entity.Admin;

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
}
