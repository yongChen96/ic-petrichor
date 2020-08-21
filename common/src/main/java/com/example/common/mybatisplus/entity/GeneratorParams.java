package com.example.common.mybatisplus.entity;

import lombok.Data;

/**
 * @ClassName: GeneratorParams
 * @Description: 代码生成参数实体
 * @Author: yongchen
 * @Date: 2020/8/19 17:27
 **/
@Data
public class GeneratorParams {

    /**
     * 表前缀
     **/
    private String tablePrefix;

    /**
     * 需要生成的表名
     **/
    private String[] tableName;

    /**
     * 包路径
     **/
    private String packagePath;

    /**
     * 模块路径
     **/
    private String modelPath;

    /**
     * 文件输出路径
     **/
    private String OutputDir;

    /**
     * 创建者
     **/
    private String Author;

    /**
     * 是否生成Entity
     **/
    private Boolean generateEntity;

    /**
     * 是否生成Mapper
     **/
    private Boolean generateMapper;

    /**
     * 是否生成Mapper.xml
     **/
    private Boolean generateXml;

    /**
     * 是否生成service
     **/
    private Boolean generateService;

    /**
     * 是否生成serviceImpl
     **/
    private Boolean generateServiceImpl;

    /**
     * 是否生成controller
     **/
    private Boolean generateController;




}
