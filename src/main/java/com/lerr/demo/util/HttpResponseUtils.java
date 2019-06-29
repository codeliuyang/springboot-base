package com.lerr.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * -
 *
 * @auther: yangliu
 * create date: 11-06-2019
 */
@Slf4j
public class HttpResponseUtils {

    public static void write(HttpServletResponse response, Object o) {
        response.setContentType("application/json; charset=utf-8");
        try(PrintWriter out = response.getWriter();){
            //json返回
            out.println(JSON.toJSONString(o, SerializerFeature.WriteMapNullValue));
            out.flush();
        } catch (Exception e) {
            log.error("e={}", e);
        }
    }

}
