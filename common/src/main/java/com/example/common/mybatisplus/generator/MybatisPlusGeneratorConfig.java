package com.example.common.mybatisplus.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.common.baseclass.BaseController;
import com.example.common.baseclass.BaseEntity;
import com.example.common.mybatisplus.entity.GeneratorParams;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MybatisPlusGeneratorConfig
 * @Description: Mybatis-pius-generator代码生成
 * @Author: yongchen
 * @Date: 2020/8/19 17:26
 **/
public class MybatisPlusGeneratorConfig {

    public static void GeneratorConfig(GeneratorParams generatorParams){
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(generatorParams.getOutputDir() + "/java");
        gc.setAuthor(generatorParams.getAuthor());
        gc.setOpen(false);
        // 实体属性 Swagger2 注解
        gc.setSwagger2(true);
        // XML生成ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        // 文件覆盖
        gc.setFileOverride(true);
        // 开启 activeRecord 模式
        gc.setActiveRecord(false);
        // XML 二级缓存
        gc.setEnableCache(false);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://112.74.161.0:3306/ic_database?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 包路径
        pc.setParent(generatorParams.getPackagePath());
        // 表前缀
//        pc.setModuleName("t");
        //文件包名
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setController("controller");
        pc.setService("service");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };

        // 如果模板引擎是 freemarker
        String templatePathController = "/templates/controller.java.ftl";
        String templatePathEntity = "/templates/entity.java.ftl";
        String templatePathService = "/templates/service.java.ftl";
        String templatePathServiceImpl = "templates/serviceImpl.java.ftl";
        String templatePathMapper = "/templates/mapper.java.ftl";
        String templatePathXml = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        if (generatorParams.getGenerateController()){
            focList.add(new FileOutConfig(templatePathController) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名
                    return generatorParams.getOutputDir() + "/java/" + generatorParams.getModelPath() +"/controller"
                            + "/" + tableInfo.getControllerName() + StringPool.DOT_JAVA;
                }
            });
        }
        if (generatorParams.getGenerateEntity()){
            focList.add(new FileOutConfig(templatePathEntity) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return generatorParams.getOutputDir() + "/java/" + generatorParams.getModelPath() +"/entity"
                            + "/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
                }
            });
        }
        if (generatorParams.getGenerateService()){
            focList.add(new FileOutConfig(templatePathService) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名
                    return generatorParams.getOutputDir() + "/java/" + generatorParams.getModelPath() +"/service"
                            + "/" + tableInfo.getServiceName() + StringPool.DOT_JAVA;
                }
            });
        }
        if(generatorParams.getGenerateServiceImpl()){
            focList.add(new FileOutConfig(templatePathServiceImpl) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名
                    return generatorParams.getOutputDir() + "/java/" + generatorParams.getModelPath() +"/service/impl"
                            + "/" + tableInfo.getServiceImplName() + StringPool.DOT_JAVA;
                }
            });
        }
        if (generatorParams.getGenerateMapper()){
            focList.add(new FileOutConfig(templatePathMapper) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名
                    return generatorParams.getOutputDir() + "/java/" + generatorParams.getModelPath() +"/mapper"
                            + "/" + tableInfo.getMapperName() + StringPool.DOT_JAVA;
                }
            });
        }
        if (generatorParams.getGenerateXml()){
            focList.add(new FileOutConfig(templatePathXml) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return generatorParams.getOutputDir() + "/resources/mapper/"
                            + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            });
        }

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setEntityBuilderModel(true);
        strategy.setRestControllerStyle(true);
        // 你自己的父类实体,没有就不用设置!
        strategy.setSuperEntityClass(BaseEntity.class);
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns(new String[]{BaseEntity.ID,BaseEntity.CREATE_TIME,BaseEntity.CREATE_USER,BaseEntity.UPDATE_TIME,BaseEntity.UPDATE_USER});
        // 公共父类 你自己的父类控制器,没有就不用设置!
        strategy.setSuperControllerClass(BaseController.class);
        // 开启TableFiled
        strategy.setEntityTableFieldAnnotationEnable(true);

        // 需要生成的表
        strategy.setInclude(generatorParams.getTableName());
        strategy.setControllerMappingHyphenStyle(true);
        // 此处可以修改为您的表前缀
        strategy.setTablePrefix(generatorParams.getTablePrefix());
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
