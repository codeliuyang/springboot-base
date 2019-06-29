package com.lerr.demo.filter;

import com.lerr.demo.security.UserMainDetail;
import com.lerr.demo.util.JwtTokenUtil;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Jwt的校验
 *
 * @auther: yangliu
 * create date: 12-06-2019
 */
@Slf4j
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
        //当token为空或格式错误时 直接放行
        if (header == null || !header.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(header);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    /**
     * 这里从token中获取用户信息并新建一个token
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String header) {

        String token = header.replace(JwtTokenUtil.TOKEN_PREFIX, "");
        try {
            String principal = JwtTokenUtil.getUserName(token);
            if (principal != null) {
                UserMainDetail userDTO = JwtTokenUtil.getUserDTO(token);
                return new UsernamePasswordAuthenticationToken(principal, null, null);
            }
        } catch (SignatureException e1){
            log.error("SignatureException", e1);
        } catch (Exception e){
            log.error("token valid error", e);
        }
        return null;
    }


}
