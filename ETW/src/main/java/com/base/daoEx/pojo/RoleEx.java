package com.base.daoEx.pojo;

import com.base.dao.pojo.Permissions;
import com.base.dao.pojo.Role;

import java.util.List;

public class RoleEx  extends Role{
    private List<Permissions> permissions;

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }
}
