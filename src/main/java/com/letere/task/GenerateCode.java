package com.letere.task;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.letere.bean.DataBase;
import com.letere.bean.Global;
import com.letere.bean.Package;
import com.letere.bean.Strategy;
import com.letere.bean.strategybean.Controller;
import com.letere.bean.strategybean.Entity;
import com.letere.bean.strategybean.Mapper;
import com.letere.bean.strategybean.Service;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.sql.Types;

/**
 * @author gaozijie
 * @date 2023-08-03
 */
@Component
public class GenerateCode {
    @Autowired
    private Global globalParams;
    @Autowired
    private DataBase dataBaseParams;
    @Autowired
    private Package packageParams;
    @Autowired
    private Strategy strategyParams;

    @PostConstruct
    public void generate() {
        System.out.println(123);
        FastAutoGenerator.create(dataBaseParams.getUrl(), dataBaseParams.getUsername(), dataBaseParams.getPassword())
                .globalConfig(builder -> {
                    builder.author(globalParams.getAuthor())
                            .outputDir(".\\code");
                    // 是否开始swagger注释
                    if (globalParams.isEnableSwagger()) {
                        builder.enableSwagger();
                    }
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    // 自定义类型转换
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent(packageParams.getParentName())
                            .moduleName(packageParams.getModuleName())
                            .controller(packageParams.getController())
                            .service(packageParams.getService())
                            .serviceImpl(packageParams.getServiceImpl())
                            .mapper(packageParams.getMapper())
                            .xml(packageParams.getXml())
                            .entity(packageParams.getEntity());
                })
                .strategyConfig(builder -> {
                    if (!ObjectUtils.isEmpty(strategyParams.getTableNames())) {
                        builder.addInclude(strategyParams.getTableNames());
                    }
                    // controller
                    Controller controllerParams = strategyParams.getController();
                    builder.controllerBuilder().enableFileOverride()
                            .formatFileName(controllerParams.getControllerName());
                    if (controllerParams.getEnableRestStyle()) {
                        builder.controllerBuilder().enableRestStyle();
                    }
                    // service
                    Service serviceParams = strategyParams.getService();
                    builder.serviceBuilder().enableFileOverride()
                            .formatServiceFileName(serviceParams.getServiceName())
                            .formatServiceImplFileName(serviceParams.getServiceImplName());
                    // mapper
                    Mapper mapperParams = strategyParams.getMapper();
                    builder.mapperBuilder().enableFileOverride()
                            .formatMapperFileName(mapperParams.getMapperName())
                            .formatXmlFileName(mapperParams.getXmlName());
                    if (mapperParams.getEnableMapperAnnotation()) {
                        builder.mapperBuilder().enableMapperAnnotation();
                    }
                    // entity
                    Entity entityParams = strategyParams.getEntity();
                    builder.entityBuilder().enableFileOverride()
                            .formatFileName(entityParams.getEntityName());
                    if (!entityParams.getEnableSerialVersionUid()) {
                        builder.entityBuilder().disableSerialVersionUID();
                    }
                    if (entityParams.getEnableLombok()) {
                        builder.entityBuilder().enableLombok();
                    }
                    if (entityParams.getEnableRemoveIsPrefix()) {
                        builder.entityBuilder().enableRemoveIsPrefix();
                    }
                    if (entityParams.getEnableActiveRecord()) {
                        builder.entityBuilder().enableActiveRecord();
                    }
                })
//                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
