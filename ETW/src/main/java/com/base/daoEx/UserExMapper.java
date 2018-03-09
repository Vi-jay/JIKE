package com.base.daoEx;

import com.base.dao.pojo.User;
import com.base.daoEx.pojo.UserEx;

public interface UserExMapper {
    UserEx selectUserExByUser(User user);
}
