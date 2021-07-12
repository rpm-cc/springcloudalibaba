package com.rpm.init.pom;

import org.apache.maven.model.Parent;

/**
 * @author: Piming Ren
 * @date: 2021/6/30 11:16
 * @version: 1.0
 * @description: useing springboot  version  2.3.2.RELEASE
 */
public class DefaultSpringBootParent extends Parent {
    private static final String suartifactId = "spring-boot-starter-parent";
    private static final String groupId = "org.springframework.boot";
    private static final String version = "2.3.2.RELEASE";

    public DefaultSpringBootParent() {
        super();
    }

    @Override
    public String getArtifactId() {
        return suartifactId;
    }

    @Override
    public String getGroupId() {
        return groupId;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public void setRelativePath(String relativePath) {
        super.setRelativePath(relativePath);
    }
}
