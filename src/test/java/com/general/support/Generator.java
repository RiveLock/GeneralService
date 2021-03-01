package com.general.support;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.general.support.common.pojo.BaseEntity;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 代码生成器
 */
public class Generator {

    /**
     * 代码作者
     */
    private final String AUTHOR = "John J";

    /**
     * 表数据
     */
    private final String TABLE_DATA = "/db/table-data.sql";

    /**
     * 包名，最终生成路径
     */
    private final String PAKEGE_NAME = "com.general.support.sample";

    /**
     * 数据库链接
     */
    private final String JDBC = "jdbc:mysql://localhost:3306/general?characterEncoding=UTF8";

    /**
     * 数据库账户
     */
    private final String USER_NAME = "root";

    /**
     * 数据库密码
     */
    private final String PASSWORD = "root";

    /**
     * 生成代码
     */
    @Test
    public void execute() throws SQLException {
        new AutoGenerator(mysqlDataSourceConfig()).global(globalConfig())  // 全局
                .packageInfo(packageConfig())  // 包名
                .strategy(strategyConfig())  // 策略
                .engine(new FreemarkerTemplateEngine())  // 引擎
                .template(templateConfig())  // 模版
                .execute();
    }

    private void runScript(DataSourceConfig dataSourceConfig) throws SQLException {
        try (Connection connection = dataSourceConfig.getConn()) {
            InputStream inputStream = Generator.class.getResourceAsStream(TABLE_DATA);
            ScriptRunner scriptRunner = new ScriptRunner(connection);
            scriptRunner.setAutoCommit(true);
            scriptRunner.runScript(new InputStreamReader(inputStream));
        }
    }

    /**
     * Mysql数据源配置
     */
    private DataSourceConfig mysqlDataSourceConfig() throws SQLException {
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder(JDBC, USER_NAME, PASSWORD).driver(com.mysql.cj.jdbc.Driver.class)
                .build();
        // 运行脚本，添加表和数据
        runScript(dataSourceConfig);
        return dataSourceConfig;
    }

    /**
     * 全局配置
     */
    private GlobalConfig globalConfig() {
        final String outPutDir = System.getProperty("user.dir") + "/src/main/java";
        return new GlobalConfig.Builder().outputDir(outPutDir).author(AUTHOR).openDir(true).fileOverride(true).swagger2(true)
                .baseResultMap(true).build();
    }

    /**
     * 包配置
     */
    private PackageConfig packageConfig() {
        return new PackageConfig.Builder().parent(PAKEGE_NAME).build();
    }

    /**
     * 策略配置
     */
    private StrategyConfig strategyConfig() {
        return new StrategyConfig.Builder().addTablePrefix("t_") //统一表前缀
                .entityBuilder()  // 实体相关配置
                .naming(NamingStrategy.underline_to_camel).columnNaming(NamingStrategy.underline_to_camel).lombok(true)
                .addSuperEntityColumns("id", "create_time", "update_time").superClass(BaseEntity.class)   //自动识别父类字段
                .addTableFills(new Column("create_time", FieldFill.INSERT))     //基于字段填充
                .addTableFills(new Property("updateTime", FieldFill.UPDATE))    //基于属性填充
                .controllerBuilder().hyphenStyle(true)  //控制器相关配置
                .build();
    }

    /**
     * 自定义模板配置
     */
    private TemplateConfig templateConfig() {
        return new TemplateConfig.Builder().all()   //激活所有默认模板
                .build();
    }

}
