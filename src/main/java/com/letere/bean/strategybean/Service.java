package com.letere.bean.strategybean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gaozijie
 * @date 2023-08-04
 */
@Component
@ConfigurationProperties(prefix = "strategy.service")
public class Service {

    private String serviceName;

    private String serviceImplName;

    public Service() {
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceImplName() {
        return serviceImplName;
    }

    public void setServiceImplName(String serviceImplName) {
        this.serviceImplName = serviceImplName;
    }
}
