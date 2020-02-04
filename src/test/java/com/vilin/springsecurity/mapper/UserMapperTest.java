package com.vilin.springsecurity.mapper;

import com.vilin.springsecurity.domain.Permission;
import com.vilin.springsecurity.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindByUsername(){
        User user = userMapper.findByUsername("eric");
        System.out.println(user);
    }

    @Test
    public void testFindByPermissionUsername(){
        List<Permission> permissions = userMapper.findPermissionByUsername("eric");
        for(Permission permission : permissions){
            System.out.println(permission.getPermTag());
        }
    }

    @Test
    public void testUpdatePassword(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String encodePassword =passwordEncoder.encode("123456");

        userMapper.updatePassword("jack", encodePassword);
    }
}
