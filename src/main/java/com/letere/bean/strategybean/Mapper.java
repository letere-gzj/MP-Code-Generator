package com.letere.bean.strategybean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gaozijie
 * @date 2023-08-04
 */
@Component
@ConfigurationProperties(prefix = "strategy.mapper")
public class Mapper {

    private Boolean enableMapperAnnotation;

    private String mapperName;

    private String xmlName;

    public Mapper() {
    }

    public Boolean getEnableMapperAnnotation() {
        return enableMapperAnnotation;
    }

    public void setEnableMapperAnnotation(Boolean enableMapperAnnotation) {
        this.enableMapperAnnotation = enableMapperAnnotation;
    }

    public String getMapperName() {
        return mapperName;
    }

    public void setMapperName(String mapperName) {
        this.mapperName = mapperName;
    }

    public String getXmlName() {
        return xmlName;
    }

    public void setXmlName(String xmlName) {
        this.xmlName = xmlName;
    }
}
