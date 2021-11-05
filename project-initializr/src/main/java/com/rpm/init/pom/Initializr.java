package com.rpm.init.pom;


import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author: Piming Ren
 * @date: 2021/6/30 9:39
 * @version: 1.0
 * @description:
 */
public class Initializr {


    public static void main(String[] args) throws IOException {

        String basePath = "D:/data/";
        String projectName = "demoProject";
        String groupId = "com.rpm.demo";

        File file = new File(basePath + projectName);
        if (!file.exists()) {
            file.mkdir();
        }

        Model model = new Model();
        Writer writer = new FileWriter(basePath + projectName + File.separator + "pom.xml");
        List<Dependency> dependencyList = new ArrayList<Dependency>();
        model.setModelVersion("4.0.0");
        model.setGroupId(groupId);
        model.setArtifactId("demoProject");
        model.setVersion("1.0.0");
        model.setParent(new DefaultSpringBootParent());
        Properties properties = new Properties();
        properties.setProperty("spring-boot.version", "2.3.2.RELEASE");
        model.setProperties(properties);
        dependencyList.add(new DefaultDependencyNode.SpringBootStarterWeb());
        dependencyList.add(new DefaultDependencyNode.SpringBootStarterDataRedis());
        dependencyList.add(new DefaultDependencyNode.SpringBootStarterThymeleaf());
        dependencyList.add(new DefaultDependencyNode.SpringBootStarterTest());
        dependencyList.add(new DefaultDependencyNode.MybatisSpringBootStarter());
        dependencyList.add(new DefaultDependencyNode.DubboSpringBootStarter());
        model.setDependencies(dependencyList);

        new MavenXpp3Writer().write(writer, model);
        writer.close();
    }
}
