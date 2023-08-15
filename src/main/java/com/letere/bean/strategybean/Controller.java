package com.letere.bean.strategybean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gaozijie
 * @date 2023-08-04
 */
@Component
@ConfigurationProperties(prefix = "strategy.controller")
public class Controller {

    private Boolean enableRestStyle;

    private String controllerName;

    public Controller() {
    }

    public Boolean getEnableRestStyle() {
        return enableRestStyle;
    }

    public void setEnableRestStyle(Boolean enableRestStyle) {
        this.enableRestStyle = enableRestStyle;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }
}
