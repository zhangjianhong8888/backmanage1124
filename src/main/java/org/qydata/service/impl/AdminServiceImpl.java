package org.qydata.service.impl;

import org.qydata.dao.AdminMapper;
import org.qydata.entity.*;
import org.qydata.service.AdminService;
import org.qydata.vo.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2016/11/23.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin get(String loginName) throws Exception {
        return this.adminMapper.findById(loginName);
    }
    @Override
    public Map<String, Object> listAuthByAdmin(String loginName) throws Exception {
        Map<String,Object> map = new HashMap<String,Object>() ;
        map.put("allRoles", this.adminMapper.findAllRoleByAdmin(loginName)) ;
        map.put("allActions", this.adminMapper.findAllActionByAdmin(loginName)) ;
        return map ;
    }

    @Override
    public List<Role> findAllRole() throws Exception {
        return adminMapper.findAllRole();
    }

    @Override
    public List<Dept> findAllDept() throws Exception {
        return adminMapper.findAllDept();
    }

    @Override
    public boolean addAdminAndRole(AdminRoleInfo adminRoleInfo) throws Exception {
        boolean flag = false;
        try {
            adminMapper.addAdmin(adminRoleInfo.getAdmin());
            RoleAdmin roleAdmin = new RoleAdmin();
            roleAdmin.setRoleId(adminRoleInfo.getRole().getId());
            roleAdmin.setLoginName(adminRoleInfo.getAdmin().getLoginName());
           flag = adminMapper.addRoleAdmin(roleAdmin);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public PageModel<Admin> findAllAdmin(Map<String,Object> map) throws Exception {
        PageModel<Admin> pageModel = new PageModel<Admin>();
        pageModel.setRows(adminMapper.getAllCountAdmin());
        pageModel.setList(adminMapper.findAllAdmin(map));
        return pageModel;
    }

    @Override
    public PageModel<Admin> findAllByColumn(Map<String, Object> map) throws Exception {
        PageModel<Admin> pageModel = new PageModel<Admin>();
        pageModel.setRows(adminMapper.getCountColumn(map));
        pageModel.setList(adminMapper.findByColumn(map));
        return pageModel;
    }

    @Override
    public boolean updateStatusStart(String longinName) throws Exception {
        return adminMapper.updateStatusStart(longinName);
    }

    @Override
    public boolean updateStatusForbid(String longinName) throws Exception {
        return adminMapper.updateStatusforbid(longinName);
    }

    @Override
    public boolean updatePassword(String loginName, String password, String newPassword) throws Exception {
        return adminMapper.updatePassword(loginName,password,newPassword);
    }
}
