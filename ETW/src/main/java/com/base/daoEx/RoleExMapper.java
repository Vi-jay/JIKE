package com.base.daoEx;

import com.base.dao.pojo.Role;
import com.base.dao.pojo.User;
import com.base.daoEx.pojo.RoleEx;
import com.base.daoEx.pojo.UserEx;

public interface RoleExMapper {
    RoleEx selectRoleExByRole(Role role);
}
