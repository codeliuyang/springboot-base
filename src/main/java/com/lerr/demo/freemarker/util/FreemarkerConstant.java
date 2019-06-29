package com.lerr.demo.freemarker.util;

import java.util.Arrays;
import java.util.List;

/**
 * -
 *
 * @auther: yangliu
 * create date: 29-06-2019
 */
public class FreemarkerConstant {

    public static final String TEMPLATE_ORIGIN_PATH = "src/main/java/com/lerr/demo/freemarker/template";
    public static final String TEMPLATE_OUTPUT_PATH = "src/main/java/com/lerr/demo/freemarker/out";

    public static String firstCharToLower(String content){
        String firstChar = content.substring(0,1);
        firstChar = firstChar.toLowerCase();
        return firstChar + content.substring(1, content.length());
    }

    public static String firstCharToUpper(String content){
        String firstChar = content.substring(0,1);
        firstChar = firstChar.toUpperCase();
        return firstChar + content.substring(1, content.length());
    }

    /**
     * person_name -> PersonName
     * @param underscore
     * @return
     */
    public static String underscoreToFullUpperName(String underscore){
        String modelName = underscore;
        String[] partTableNames = modelName.split("_");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < partTableNames.length; i++){
            sb.append(firstCharToUpper(partTableNames[i]));
        }
        modelName = sb.toString();
        return modelName;
    }

    /**
     * person_name -> PersonName
     * @param underscore
     * @return
     */
    public static String underscoreToFullCamelName(String underscore){
        String modelName = underscore;
        String[] partTableNames = modelName.split("_");
        StringBuilder sb = new StringBuilder();
        sb.append(partTableNames[0]);
        for(int i = 1; i < partTableNames.length; i++){
            sb.append(firstCharToUpper(partTableNames[i]));
        }
        modelName = sb.toString();
        return modelName;
    }

    public static boolean igonreColumnName(String column){
        List<String> ignoreColumns = Arrays.asList("del_flg"
                ,"create_time"
                ,"create_user"
                ,"update_time"
                ,"update_user");
        if(ignoreColumns.contains(column)){
            return true;
        } else {
            return false;
        }
    }

}
