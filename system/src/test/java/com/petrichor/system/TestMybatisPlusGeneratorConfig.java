package com.petrichor.system;

import com.example.common.mybatisplus.entity.GeneratorParams;
import com.example.common.mybatisplus.generator.MybatisPlusGeneratorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


/**
 * @ClassName: TestMybatisPlusGeneratorConfig
 * @Description: //TODO
 * @Author: yongchen
 * @Date: 2020/8/19 17:55
 **/
public class TestMybatisPlusGeneratorConfig {

    public static void main(String[] args) {
        GeneratorParams generatorParams = new GeneratorParams();
        generatorParams.setAuthor("yongchen");
        generatorParams.setGenerateController(false);
        generatorParams.setGenerateService(true);
        generatorParams.setGenerateServiceImpl(true);
        generatorParams.setGenerateMapper(true);
        generatorParams.setGenerateXml(true);
        generatorParams.setGenerateEntity(true);
        generatorParams.setPackagePath("com.petrichor.system");
        generatorParams.setModelPath("com/petrichor/system");
        generatorParams.setOutputDir(System.getProperty("user.dir") + "/system/src/main");
        generatorParams.setTableName(new String[]{"t_sys_log"});
        generatorParams.setTablePrefix("t_");
        MybatisPlusGeneratorConfig mybatisPlusGeneratorConfig = new MybatisPlusGeneratorConfig();
        mybatisPlusGeneratorConfig.GeneratorConfig(generatorParams);
    }
}
