#项目框架结构说明文档v1.1.doc

### 整体架构：
基于Maven构建的`springmvc`、`spring`、`mybatis-plus`、`shiro`、`Druid监控`、`log4j2`、`velocity模板引擎`、`前端集成datatable`、`vue.js`、`Element`、`layui`、`easyui`的系统

#### 前端：
基于**jQuery EasyUI、datatable、vue.js、Element、layui、easyui**

`My97DataPicker` 时间日期组件

#### 日志：

##### Log4j2
配置文件：

- Log4j2 采用的是.xml、.json或者.jsn
- Log4j2.xml放置在resource目录下。
- 也可以修改为 log4j 的配置文件.properties （这个需要到web.xml里面配置监听）

#### 目录结构：
##### src\main\java\com\ian\commons

- Annotation 	自定义注解
	 Base       	基础通用controller
	 Csrf			预防csrf攻击
	 Interceptor		拦截器接口
	 Mybatis		mybatis-plus 全局配置
	 Result		result 是异步请求统一格式的返回集；Tree是zTree的传输对象，两个都继承了序列化接口
	 Scan			一些要扫描的组件
	 Shiro			shiro框架相关
	 Utils			一些常用的工具包

##### src\main\java\com\ian

- controller		控制器
	 Event			自动更新打包部署到git的webhook功能（暂时不用）
	 Mapper		mybatis接口层
	 Model		实体类
	 Service		业务层
	 Task			定时任务

##### src\main\resources
- Spring	spring、ehcache、mybatis、redis、shiro、task集成
	 Mapping	mybatis的xml实现
	 Xml		ehcache、mybatis-plus的配置文件
	 Spring-config.xml、spring-mvc.xml 	spring的配置文件	
有2个缓存机制，ehcache 和 redis（注释），目前只用ehcache。

##### src\main\conf\dev
- Config		系统一些插件的参数定义的配置文件
	 Templates		使用velocity技术为controller定义生成模板
	 log4j2-test.xml	开发环境中的日志配置	


##### src\main\conf\production
- 生产环境的一些配置（暂时不用）

##### src\main\webapp
- Commons		通用标签和样式
	 Static			静态css和js等文件

##### src\main\webapp\WEB-INF
- Views			jsp视图层


### 运行环境
jdk8 + tomcat8！

采用maven profile配置线下dev和线上production环境，默认读取src\main\conf\dev开发环境下的配置文件。

线上环境使用mvnrun、打包时添加-Pproduction变量则会使用src/main/conf/production目录下的配置文件。

线上production请注意添加一份cofing/application.properties配置文件


### 使用redis缓存
pom.xml中将redis放开，将ehcahe注掉!
spring-config.xml中把ehcache注掉，把redis放开！


### shiro权限注解
###@RequiresAuthentication

表示当前Subject已经通过login进行了身份验证；即Subject. isAuthenticated()返回true。

###@RequiresUser
表示当前Subject已经身份验证或者通过记住我登录的。

###@RequiresGuest
表示当前Subject没有身份验证或通过记住我登录过，即是游客身份。

###@RequiresRoles
@RequiresRoles(value={“admin”, “user”}, logical= Logical.AND) 表示当前Subject需要角色admin和user。

###@RequiresPermissions 
@RequiresPermissions(value={“user:a”, “user:b”}, logical= Logical.OR) 表示当前Subject需要权限user:a或user:b。


### Validation注解

// Bean Validation 中内置的 constraint  
@Null   被注释的元素必须为 null  
@NotNull    被注释的元素必须不为 null  
@AssertTrue     被注释的元素必须为 true  
@AssertFalse    被注释的元素必须为 false  
@Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值  
@Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值  
@DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值  
@DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值  
@Size(max=, min=)   被注释的元素的大小必须在指定的范围内  
@Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内  
@Past   被注释的元素必须是一个过去的日期  
@Future     被注释的元素必须是一个将来的日期  
@Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式  

// Hibernate Validator 附加的 constraint  
@NotBlank(message =)   验证字符串非null，且长度必须大于0  
@Email  被注释的元素必须是电子邮箱地址  
@Length(min=,max=)  被注释的字符串的大小必须在指定的范围内  
@NotEmpty   被注释的字符串的必须非空  
@Range(min=,max=,message=)  被注释的元素必须在合适的范围内

![](http://uniquezhangqi.oss-cn-shenzhen.aliyuncs.com/blog/2018-07-17-0.png)
![](http://uniquezhangqi.oss-cn-shenzhen.aliyuncs.com/blog/2018-07-17-1.png)
![](http://uniquezhangqi.oss-cn-shenzhen.aliyuncs.com/blog/2018-07-17-2.png)
![](http://uniquezhangqi.oss-cn-shenzhen.aliyuncs.com/blog/2018-07-17-3.png)
![](http://uniquezhangqi.oss-cn-shenzhen.aliyuncs.com/blog/2018-07-17-4.png)
![](http://uniquezhangqi.oss-cn-shenzhen.aliyuncs.com/blog/2018-07-17-5.png)
![](http://uniquezhangqi.oss-cn-shenzhen.aliyuncs.com/blog/2018-07-17-104613.png)
