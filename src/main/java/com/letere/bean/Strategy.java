package com.letere.bean;

import com.letere.bean.strategybean.Controller;
import com.letere.bean.strategybean.Entity;
import com.letere.bean.strategybean.Mapper;
import com.letere.bean.strategybean.Service;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @author gaozijie
 * @date 2023-08-04
 */
@Component
@ConfigurationProperties(prefix = "strategy")
public class Strategy {

    private String tableNames;

    private Controller controller;

    private Service service;

    private Mapper mapper;

    private Entity entity;

    public Strategy() {
    }

    public String getTableNames() {
        return tableNames;
    }

    public void setTableNames(String tableNames) {
        this.tableNames = tableNames;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Mapper getMapper() {
        return mapper;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
