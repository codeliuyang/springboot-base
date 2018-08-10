# springboot-base
If you need a project to develop as a base project. This demo will be a good choice.That is what I want to provide.

## Base Framework
Spring Boot 2.0.4.RELEASE

MyBatis

LogBack

### Spring Boot
SpringBoot简化了很多相关的工程配置，几乎不需要任何xml配置，即可一键构建我们需要的web工程。同时内嵌Tomcat。

启动工程，只需要启动主类即可。不再需要额外配置Tomcat

### MyBatis
本工程既支持xml写法，同时也支持注解的方法，看适用场景即可

- @MapperScan 扫描了mapper类所在的位置，即interface
- mybatis.mapper-locations 定义了mapper xml的位置

### MyBatis-Generator
MyBatis Generator 能够对应每张表生成对应的实体、mapper xml以及mapper类。

其配置文件为resouces/generatorConfig.xml

该Generator简化开发步骤，直接提供可用的实体和持久层(或即repository层)

如果你是IDEA开发，直接找到mybatis-generator:generate双击即可