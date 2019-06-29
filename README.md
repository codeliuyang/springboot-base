# springboot-base
If you need a project to develop as a base project. This demo will be a good choice.That is what I want to provide.

## Related Framework
- Spring Boot 2.0.4.RELEASE
- MyBatis
- MyBatis PageHelper
- Slf4j + LogBack
- Druid
- Swagger

## Related Plugins
- Lombok  简化工程内模板化的代码，用注解替代(@Data @Slf4j ...)

## Structure Of Project
````
|- /src
  |- /main
    |- /java
      |- /com/lerr/demo
        |- /api
        |- /config
          |- RestTemplate.java
          |- Swagger2.java
        |- /dto
        |- /mapper/dao
          |- /custom
          |- /gen
        |- /model/gen
        |- /service
          |- /impl
        |- /vo
      |- SpringbootBaseDemoApplication.java
    |- /resources
      |- /mybatis/mapper/xml/gen
      |- /static
      |- /templates
      |- application.properties
      |- application-dev.properties
      |- application-prod.properties
      |- application-test.properties
      |- generatorConfig.xml
      |- logback-spring.xml
|- pom.xml
|- READE.md
````

### Spring Boot
SpringBoot简化了很多相关的工程配置，几乎不需要任何xml配置，即可一键构建我们需要的web工程。同时内嵌Tomcat。

启动工程，只需要启动主类即可。不再需要额外配置Tomcat

### MyBatis
本工程既支持xml写法，同时也支持注解的方法，看适用场景即可
使用PageHelper支持分页

- @MapperScan 扫描了mapper类所在的位置，即interface
- mybatis.mapper-locations 定义了mapper xml的位置

### MyBatis-Generator
MyBatis Generator 能够对应每张表生成对应的实体、mapper xml以及mapper类。

其配置文件为resouces/generatorConfig.xml

该Generator简化开发步骤，直接提供可用的实体和持久层(或即repository层)

如果你是IDEA开发，直接找到mybatis-generator:generate双击即可

### Druid
工程配置Druid代替默认的数据源，能够提供页面监控数据源，以及sql等。

现在官方也提供了Spring Boot集成的方式，而且简化配置

GitHub 搜索关键词 ```druid-spring-boot-starter```

工程启动后访问地址
```
../druid
```


### Swagger
Swagger现在常用于API管理。与工程结合起来，非常方便。只要工程提供服务，则可以访问。

同时也能规范项目的API文档和整理。不用再另起excel或者word这种文档之类的东西了。

访问路径为 
```
../swagger-ui.html
```

### 日志框架
日志框架选择的是Slf4j+LogBack，Logback作为具体的日志实现。配置文件即为```logback-spring.xml```。
配置了日志在控制台的打印，以及日志文件的生成。

同时控制不同级别的日志打印到不同的日志文件里面去

### RestTemplate
RestTemplateConfig，配置RestTemplate

### Spring Security
工程利用security框架进行验证授权，同时使用jwtToken进行前后端的验证
目前已配置默认登陆用户名和密码
```
{
	"username":"admin",
	"password":"1231234"
}
```

### Freemarker
工程利用freemarker进行api, service, service.impl 相关类的生成