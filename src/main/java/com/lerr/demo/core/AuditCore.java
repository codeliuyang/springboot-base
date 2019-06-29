package com.lerr.demo.core;


import com.little.animal.security.CurrentLoginUserInfo;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

/**
 * -
 *
 * @auther: yangliu
 * create date: 08-06-2019
 */
@Slf4j
public class AuditCore {

    /**
     * 在创建操作时更新审计字段
     *
     * @param object
     */
    public static void setAuditPropsForCreated(Object object) {
        Date currentTime = Calendar.getInstance().getTime();
        String operator = getOperator();
        setDelFlgValue(object, "setDelFlag");
        setObjValue(object, "setCreateUser", String.class, operator);
        setObjValue(object, "setCreateTime", Date.class, currentTime);
        setObjValue(object, "setUpdateUser", String.class, operator);
        setObjValue(object, "setUpdateTime", Date.class, currentTime);
    }

    /**
     * 在更新操作时更新审计字段
     *
     * @param object
     */
    public static void setAuditPropsForUpdated(Object object) {
        Date currentTime = Calendar.getInstance().getTime();
        String operator = getOperator();
        setObjValue(object, "setUpdateUser", String.class, operator);
        setObjValue(object, "setUpdateTime", Date.class, currentTime);
    }

    private static String getOperator() {
         String operator = CurrentLoginUserInfo.getName();
        return operator;
    }

    private static void setObjValue(Object obj, String stMethod, Class<?> paramType, Object paramValue) {
        Class<?> clz = obj.getClass();
        Method method;
        try {
            method = clz.getMethod(stMethod, paramType);
            method.invoke(obj, paramValue);
        } catch (NoSuchMethodException e) {
            log.error("AuditUtils.setObjValue系统出错", e);
        } catch (SecurityException e) {
            log.error("AuditUtils.setObjValue系统出错", e);
        } catch (IllegalAccessException e) {
            log.error("AuditUtils.setObjValue系统出错", e);
        } catch (IllegalArgumentException e) {
            log.error("AuditUtils.setObjValue系统出错", e);
        } catch (InvocationTargetException e) {
            log.error("AuditUtils.setObjValue系统出错", e);
        }
    }

    private static void setDelFlgValue(Object obj, String stMethod) {
        Class<?> clz = obj.getClass();
        Method method;
        try {
                method = clz.getMethod(stMethod, Integer.class);
                method.invoke(obj, new Integer("0"));
            } catch (NoSuchMethodException e) {
                log.error("AuditUtils.setObjValue系统出错", e);
            } catch (SecurityException e) {
                log.error("AuditUtils.setObjValue系统出错", e);
            } catch (IllegalAccessException e) {
                log.error("AuditUtils.setObjValue系统出错", e);
            } catch (IllegalArgumentException e) {
                log.error("AuditUtils.setObjValue系统出错", e);
            } catch (InvocationTargetException e) {
                log.error("AuditUtils.setObjValue系统出错", e);
            }
    }



}
