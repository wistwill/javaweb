package com.ian.commons.core;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import net.dreamlu.tool.generator.MySqlTypeConvert;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * <p>
 * MySQL 生成
 * </p>
 */
public class MysqlGenerator {

    public static void main(String[] args) {
        /* 获取 JDBC 配置文件 */
        Properties props = getProperties();
        AutoGenerator mpg = new AutoGenerator();
        String author = props.getProperty("author");
        String outputDir = getOutputDir();
        final String viewOutputDir = outputDir + "/view/";
        final String sqlOutputDir = outputDir + "/sql/";

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outputDir);
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 开启 activeRecord 模式
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor(author);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUrl(props.getProperty("spring.datasource.url"));
        dsc.setUsername(props.getProperty("spring.datasource.username"));
        dsc.setPassword(props.getProperty("spring.datasource.password"));
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名
        // strategy.setDbColumnUnderline(true);//全局下划线命名
        strategy.setTablePrefix(new String[]{"t_"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
//		strategy.setInclude(new String[] { "t_sys_log" }); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        strategy.setSuperEntityClass("net.dreamlu.system.base.UserVo");
        // 自定义实体，公共字段
        strategy.setSuperEntityColumns(new String[]{"id" , "status" , "create_time" , "update_time"});
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        strategy.setSuperServiceClass("net.dreamlu.system.base.IService");
        // 自定义 service 实现类父类
        strategy.setSuperServiceImplClass("net.dreamlu.system.base.ServiceImpl");
        // 自定义 controller 父类
        strategy.setSuperControllerClass("net.dreamlu.common.support.BaseController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        strategy.setEntityBuilderModel(false);
        strategy.setEntityBuilderModel(true);
//        strategy.setEntityLombokModel(true);
        // 逻辑删除时，就查询不到该数据了，弃用
//		strategy.setLogicDeleteFieldName("status");
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null);  //所属模块
        pc.setParent("com.ian"); // 自定义包路径
        pc.setController("controller"); // 这里是控制器包名，默认 web
        pc.setEntity("model");
        pc.setXml("mapper");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();


        focList.add(new FileOutConfig("/templates/add.jsp.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 注意：由于上面添加公用字段，添加到commonFields里了
                List<TableField> list = tableInfo.getFields();
                tableInfo.getCommonFields().stream().forEach(x -> {
                    if (x.getPropertyName().equals("status") && !list.contains(x)) {
                        list.add(x);
                    }
                });
                return getGeneratorViewPath(viewOutputDir, tableInfo, "Add.jsp");
            }
        });


        focList.add(new FileOutConfig("/templates/edit.jsp.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 注意：由于上面添加公用字段，添加到commonFields里了
                List<TableField> list = tableInfo.getFields();
                tableInfo.getCommonFields().stream().forEach(x -> {
                    if (x.getPropertyName().equals("status") && !list.contains(x)) {
                        list.add(x);
                    }
                });
                return getGeneratorViewPath(viewOutputDir, tableInfo, "Edit.jsp");
            }
        });
        focList.add(new FileOutConfig("/templates/list.jsp.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getGeneratorViewPath(viewOutputDir, tableInfo, "List.jsp");
            }
        });
        File viewDir = new File(sqlOutputDir);
        if (!viewDir.exists()) {
            viewDir.mkdirs();
        }

//        focList.add(new FileOutConfig("/templates/resource.sql.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                String name = StringUtils.firstToLowerCase(tableInfo.getEntityName());
//                return sqlOutputDir + "/resource-"  + name + ".sql";
//            }
//        });


        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 执行生成
        mpg.execute();
    }

    /**
     * 获取配置文件
     *
     * @return 配置Props
     */
    private static Properties getProperties() {
        // 读取配置文件
        Resource resource = new ClassPathResource("generator.properties");
        Properties props = new Properties();
        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    /**
     * 生成到gen_code文件夹（没有会自动创建）
     *
     * @return outputDir
     */
    public static String getOutputDir() {
        return System.getProperty("user.dir") + "/gen_code";
    }

    /**
     * 页面生成的文件名
     */
    private static String getGeneratorViewPath(String viewOutputDir, TableInfo tableInfo, String suffixPath) {
        String name = StringUtils.firstToLowerCase(tableInfo.getEntityName());
        String path = viewOutputDir + "/" + name + "/" + name + suffixPath;
        File viewDir = new File(path).getParentFile();
        if (!viewDir.exists()) {
            viewDir.mkdirs();
        }
        return path;
    }
}
