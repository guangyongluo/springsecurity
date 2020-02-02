package com.vilin.springsecurity.mapper;

import com.vilin.springsecurity.domain.Permission;
import com.vilin.springsecurity.domain.User;

import java.util.List;

public interface UserMapper {

    public User findByUsername(String username);

    public List<Permission> findPermissionByUsername(String username);
}
