package com.lerr.demo.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

/**
 * -
 *
 * @auther: yangliu
 * create date: 13-06-2019
 */
public class CurrentLoginUserInfo {

    /**
     * 获取当前登录用户名
     * @return
     */
    public static String getName(){
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(StringUtils.isEmpty(username)){
            return "system";
        }
        return username;
    }

}
