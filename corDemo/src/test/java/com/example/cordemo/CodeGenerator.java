package com.example.cordemo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.nio.file.Paths;
import java.util.Collections;

public class CodeGenerator {
    private static String url = "jdbc:mysql://47.94.94.217:3306/workTest?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "likang1206L!";
    public static void main(String[] args) {
//        FastAutoGenerator.create(url, "root", "likang1206L!")
//                .globalConfig(builder -> {
//                    builder.author("lch") // 设置作者
//                            .outputDir("E:\\GitCODE\\springBootDemo\\corDemo\\src\\main\\java"); // 指定输出目录
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com.example.cordemo") // 设置父包名
//                            .moduleName("model") // 设置模块名
//                            .pathInfo(Collections.singletonMap(OutputFile.xml, "E:\\GitCODE\\springBootDemo\\corDemo\\src\\main\\resources\\mabatisMappers")); // 设置mapperXml生成路径
//                })
//                .strategyConfig(builder -> {
//                    builder.addInclude("tbl_pay_billinfo") // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
//                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//                .execute();



        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    // 使用 Paths.get 构建跨平台兼容的输出目录
                    builder.author("lch")
                            .outputDir(Paths.get(System.getProperty("user.dir"), "corDemo","src", "main", "java").toString())
                            .commentDate("yyyy-MM-dd");
                })
                .packageConfig(builder -> {
                    // 设置正确的 Java 包名
                    builder.parent("com.example.cordemo.model")
                            .entity("model")
                            .mapper("mapper")
                            .service("service")
                            .serviceImpl("service.impl")
                            // 配置 Mapper XML 文件的输出路径
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
                                    Paths.get(System.getProperty("user.dir"), "corDemo","src", "main", "resources", "mybatisMappers").toString()));
                })
                .strategyConfig(builder -> {
                    // 指定要生成代码的表名
                    builder.addInclude("tbl_pay_billinfo")
                            .entityBuilder()
                            .enableLombok() // 启用 Lombok
                            .enableTableFieldAnnotation() // 启用字段注解
                            .controllerBuilder()
                            .enableRestStyle(); // 启用 REST 风格
                })

                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}