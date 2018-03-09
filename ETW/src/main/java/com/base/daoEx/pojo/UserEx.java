package com.base.daoEx.pojo;

import com.base.dao.pojo.Role;
import com.base.dao.pojo.User;

import java.util.List;

public class UserEx extends User {
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
