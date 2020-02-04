package com.vilin.springsecurity.security;

import com.vilin.springsecurity.domain.Permission;
import com.vilin.springsecurity.domain.User;
import com.vilin.springsecurity.mapper.UserMapper;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MyUserDetailService implements UserDetailsService {
    private static final Logger log = Logger.getLogger(MyUserDetailService.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username + "is not found.");
        }
        List<Permission> permissionList = userMapper.findPermissionByUsername(username);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        for(Permission permission : permissionList){
            GrantedAuthority authority = new SimpleGrantedAuthority(permission.getPermTag());
            grantedAuthorityList.add(authority);
        }
        user.setAuthorities(grantedAuthorityList);

        log.info(user);
        return user;
    }
}
