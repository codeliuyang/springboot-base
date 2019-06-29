package com.lerr.demo.util;

import com.alibaba.fastjson.JSON;
import com.lerr.demo.security.UserMainDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * -
 *
 * @auther: yangliu
 * create date: 12-06-2019
 */
public class JwtTokenUtil {

    /**
     * header名称
     */
    public static final String TOKEN_HEADER = "Ani-Authorization";

    /**
     * token前缀
     */
    public static final String TOKEN_PREFIX = "jwttoken-";

    /**
     * 秘钥
     */
    private static final String SECRET = "today";

    /**
     * 过期时间，秒数
     */
    private static final Long EXPIRATION = 3600 * 2L;


    /**
     * 生成token
     *
     * @param userMain
     * @return
     */
    public static String createToken(UserMainDetail userMain) {
        Long time = EXPIRATION;
        Map<String, Object> map = new HashMap<>(1);
        map.put("user", userMain);
        return Jwts.builder()
                .setClaims(map)
                .setSubject(userMain.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + time * 1000))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    /**
     * 获取用户名
     *
     * @param token
     * @return
     */
    public static String getUserName(String token) {
        return generateToken(token).getSubject();
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public static Claims generateToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 获取userMain
     *
     * @param token
     * @return
     */
    public static UserMainDetail getUserDTO(String token) {
        Claims claims = generateToken(token);
        Map<String, String> map = claims.get("user", Map.class);
        UserMainDetail userDTO = JSON.parseObject(JSON.toJSONString(map), UserMainDetail.class);
        return userDTO;
    }

}
