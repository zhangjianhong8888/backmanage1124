package org.qydata.service.impl;

import org.qydata.dao.AdminMapper;
import org.qydata.entity.Admin;
import org.qydata.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
}
