package com.tingyu.mp.test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @author Essionshy
 * @create 2019/11/25-21:15
 */
public class MPGenerrator {

    @Test
    public void testGenerator() {
        //1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("Essionshy")
                .setActiveRecord(true)      //是否支持AR
                .setBaseColumnList(true)    //开启后会自动生成sql片段
                .setFileOverride(true)      //是否文件覆盖
                .setBaseResultMap(true)
                .setServiceName("%sService")
                .setIdType(IdType.AUTO)
                .setOutputDir("E:/IdeaProjects/study-mp/src/main/java");

        //2.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://127.0.0.1:3306/repository")
                .setUsername("root")
                .setPassword("root-xz");
        //3.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setTablePrefix("tbl_")
                .setEntityLombokModel(true)
                .setNaming(NamingStrategy.underline_to_camel) //表字段映射实体类属性下划线转驼峰命名
                .setDbColumnUnderline(true);
        //4.包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.tingyu.mp")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("entity")
                .setXml("mapper");
        //5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);
        autoGenerator.execute();
    }
}
