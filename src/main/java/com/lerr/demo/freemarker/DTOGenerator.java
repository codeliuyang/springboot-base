package com.lerr.demo.freemarker;

import com.lerr.demo.freemarker.util.DatabaseTypeUtil;
import com.lerr.demo.freemarker.util.DatabaseUtil;
import com.lerr.demo.freemarker.util.FreemarkerConstant;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * -
 *
 * @auther: yangliu
 * create date: 29-06-2019
 */
public class DTOGenerator {

    public static void main(String[] args){

    }

    public static void generatoDTO(List<String> tableNames){
        Configuration configuration = new Configuration();
        File outputDir = new File(FreemarkerConstant.TEMPLATE_OUTPUT_PATH);
        if(!outputDir.exists()){
            outputDir.mkdir();
        }
        for(String tableName: tableNames){

            List<String> columnNames = DatabaseUtil.getColumnNames(tableName);
            List<String> types = DatabaseUtil.getColumnTypes(tableName);
            List<String> comments = DatabaseUtil.getColumnComments(tableName);
            String tableComment = "";
            String props = new String();
            String ims = new String();

            String upper = FreemarkerConstant.underscoreToFullUpperName(tableName);
            Map<String, String> dataMap = new HashMap<>();

            for(int i = 0; i < columnNames.size(); i++){
                String columnName  = columnNames.get(i);
                String dbType = types.get(i);
                String comment = comments.get(i);
                String javaType = DatabaseTypeUtil.toJavaType(dbType);
                String[] javaTypes = javaType.split(",");
                if(FreemarkerConstant.igonreColumnName(columnName)){
                    continue;
                }
                String prop = new String("    @ApiModelProperty(value = \"" + comment + "\")\n" +
                        "    private " + javaTypes[1] + " " + FreemarkerConstant.underscoreToFullCamelName(columnName) +";\n");
                if(javaTypes[2].equals("1")){
                    ims +=  "import " + javaTypes[0] + ";\n";
                }
                props += prop;
            }

            dataMap.put("domainNameUpper", upper);
            dataMap.put("propertiesInfo", props);
            dataMap.put("ims", ims);
            dataMap.put("tableComment", tableComment);
            File dtoFile = new File(FreemarkerConstant.TEMPLATE_OUTPUT_PATH + "/" + upper + "DTO.java");
            try(Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dtoFile)))) {
                configuration.setDirectoryForTemplateLoading(new File(FreemarkerConstant.TEMPLATE_ORIGIN_PATH));
                Template template = configuration.getTemplate("dto.ftl");
                template.process(dataMap, out);
                System.out.println(upper + "DTO.java" + " ...file created");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
