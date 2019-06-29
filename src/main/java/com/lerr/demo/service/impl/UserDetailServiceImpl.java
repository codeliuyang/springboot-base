package com.lerr.demo.service.impl;

import com.lerr.demo.security.UserMainDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 登陆逻辑
 * /login
 *
 * @auther: yangliu
 * create date: 29-06-2019
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 以下逻辑可修改为具体项目逻辑
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserMainDetail detail = new UserMainDetail();
        detail.setUsername("admin");
        detail.setPassword(passwordEncoder.encode("123123"));
        return detail;
    }

}
