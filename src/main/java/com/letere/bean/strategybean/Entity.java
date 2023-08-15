package com.letere.bean.strategybean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gaozijie
 * @date 2023-08-04
 */
@Component
@ConfigurationProperties(prefix = "strategy.entity")
public class Entity {

    private Boolean enableSerialVersionUid;

    private Boolean enableLombok;

    private Boolean enableRemoveIsPrefix;

    private Boolean enableActiveRecord;

    private String entityName;

    public Entity() {
    }

    public Boolean getEnableSerialVersionUid() {
        return enableSerialVersionUid;
    }

    public void setEnableSerialVersionUid(Boolean enableSerialVersionUid) {
        this.enableSerialVersionUid = enableSerialVersionUid;
    }

    public Boolean getEnableLombok() {
        return enableLombok;
    }

    public void setEnableLombok(Boolean enableLombok) {
        this.enableLombok = enableLombok;
    }

    public Boolean getEnableRemoveIsPrefix() {
        return enableRemoveIsPrefix;
    }

    public void setEnableRemoveIsPrefix(Boolean enableRemoveIsPrefix) {
        this.enableRemoveIsPrefix = enableRemoveIsPrefix;
    }

    public Boolean getEnableActiveRecord() {
        return enableActiveRecord;
    }

    public void setEnableActiveRecord(Boolean enableActiveRecord) {
        this.enableActiveRecord = enableActiveRecord;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
