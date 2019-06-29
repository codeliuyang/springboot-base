package com.lerr.demo.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * -
 *
 * @auther: yangliu
 * create date: 08-06-2019
 */
public class Generator {

    private static final String TEMPLATE_ORIGIN_PATH = "src/main/java/com/lerr/demo/freemarker/template";
    private static final String TEMPLATE_OUTPUT_PATH = "src/main/java/com/lerr/demo/freemarker/out";

    public static void main(String[] args){
        Configuration configuration = new Configuration();
        File outputDir = new File(TEMPLATE_OUTPUT_PATH);
        if(!outputDir.exists()){
            outputDir.mkdir();
        }
        List<TemplateModel> waitToGenerate = new ArrayList<>();
        waitToGenerate.add(new TemplateModel("用户模块", "Person", "com.lerr.demo"));
        for(TemplateModel model: waitToGenerate){
            String upper = model.getDomainNameUpper();
            File apiFile = new File(TEMPLATE_OUTPUT_PATH + "/" + upper + "Api.java");
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("comment", model.getComment());
            dataMap.put("domainNameAllLower", model.getDomainNameUpper().toLowerCase());
            dataMap.put("domainNameUpper", model.getDomainNameUpper());
            dataMap.put("domainNameLower", firstCharToLower(model.getDomainNameUpper()));
            dataMap.put("packageName", model.getPackageName());
            try(Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(apiFile)));) {
                configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_ORIGIN_PATH));
                Template template = configuration.getTemplate("api.ftl");
                template.process(dataMap, out);
                System.out.println(upper + "Api.java" + " ...file created");
            } catch (Exception e){
                e.printStackTrace();
            }
            File serviceFile = new File(TEMPLATE_OUTPUT_PATH + "/" + upper + "Service.java");
            try(Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceFile)));) {
                configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_ORIGIN_PATH));
                Template template = configuration.getTemplate("service.ftl");
                template.process(dataMap, out);
                System.out.println(upper + "Service.java" + " ...file created");
            } catch (Exception e){
                e.printStackTrace();
            }
            File servieImplFile = new File(TEMPLATE_OUTPUT_PATH + "/" + upper + "ServiceImpl.java");
            try(Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(servieImplFile)));) {
                configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_ORIGIN_PATH));
                Template template = configuration.getTemplate("serviceimpl.ftl");
                template.process(dataMap, out);
                System.out.println(upper + "ServiceImpl.java" + " ...file created");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static String firstCharToLower(String content){
        String firstChar = content.substring(0,1);
        firstChar = firstChar.toLowerCase();
        return firstChar + content.substring(1, content.length());
    }

}
