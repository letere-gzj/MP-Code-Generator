package com.letere.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gaozijie
 * @date 2023-08-03
 */
@Component
@ConfigurationProperties(prefix = "global")
public class Global {

    private String author;

    private boolean enableSwagger;

    public Global() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isEnableSwagger() {
        return enableSwagger;
    }

    public void setEnableSwagger(boolean enableSwagger) {
        this.enableSwagger = enableSwagger;
    }
}
