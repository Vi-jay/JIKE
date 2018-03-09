package com.base.service;

import com.base.dao.pojo.Role;
import com.base.dao.pojo.User;
import com.base.daoEx.RoleExMapper;
import com.base.daoEx.UserExMapper;
import com.base.daoEx.pojo.RoleEx;
import com.base.daoEx.pojo.UserEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleExMapper roleExMapper;

    public RoleEx getRoleByRole(Role role){

        return roleExMapper.selectRoleExByRole(role);
    }
}
