package com.lerr.demo.freemarker.util;

/**
 * -
 *
 * @auther: yangliu
 * create date: 29-06-2019
 */
public class DatabaseTypeUtil {

    public static String toJavaType(String databaseType){
        switch (databaseType){
            case "BIGINT":
                return "java.lang.Long,Long,0";
            case "INTEGER":
                return "java.lang.Integer,Integer,0";
            case "VARCHAR":
                return "java.lang.String,String,0";
            case "DATETIME":
                return "java.util.Date,Date,1";
            default:
                return "java.lang.String,String,0";
        }
    }

}
