package com.shiny.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "file")
public class GetInfoFromYml {
    private String copyPath;

    public String getCopyPath() {
        return copyPath;
    }

    public void setCopyPath(String copyPath) {
        this.copyPath = copyPath;
    }
}
