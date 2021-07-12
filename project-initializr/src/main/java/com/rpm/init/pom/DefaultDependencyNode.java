package com.rpm.init.pom;

import org.apache.maven.model.Dependency;

/**
 * @author: Piming Ren
 * @date: 2021/6/30 10:25
 * @version: 1.0
 * @description:
 */
public class DefaultDependencyNode {


    /**
     * build a dependency node
     * <dependency>
     * <groupId>org.springframework.boot</groupId>
     * <artifactId>spring-boot-starter-web</artifactId>
     * </dependency>
     */
    public static class SpringBootStarterWeb extends Dependency {
        public SpringBootStarterWeb() {
            super();
        }

        @Override
        public String getArtifactId() {
            return "spring-boot-starter-web";
        }

        @Override
        public String getGroupId() {
            return "org.springframework.boot";
        }
    }

    /**
     * build a dependency node
     * <dependency>
     * <groupId>org.springframework.boot</groupId>
     * <artifactId>spring-boot-starter-data-redis</artifactId>
     * </dependency>
     */
    public static class SpringBootStarterDataRedis extends Dependency {
        public SpringBootStarterDataRedis() {
            super();
        }

        @Override
        public String getArtifactId() {
            return "spring-boot-starter-data-redis";
        }

        @Override
        public String getGroupId() {
            return "org.springframework.boot";
        }
    }

    /**
     * <dependency>
     * <groupId>org.mybatis.spring.boot</groupId>
     * <artifactId>mybatis-spring-boot-starter</artifactId>
     * <version>2.1.4</version>
     * </dependency>
     */
    public static class MybatisSpringBootStarter extends Dependency {
        Dependency dependency = new Dependency();

        @Override
        public String getArtifactId() {
            return "mybatis-spring-boot-starter";
        }

        @Override
        public String getGroupId() {
            return "org.mybatis.spring.boot";
        }

        @Override
        public String getVersion() {
            return "2.1.4";
        }
    }

    /**
     * <dependency>
     * <groupId>org.springframework.boot</groupId>
     * <artifactId>spring-boot-starter-thymeleaf</artifactId>
     * </dependency>
     */
    public static class SpringBootStarterThymeleaf extends Dependency {
        Dependency dependency = new Dependency();

        @Override
        public String getArtifactId() {
            return "spring-boot-starter-thymeleaf";
        }

        @Override
        public String getGroupId() {
            return "org.springframework.boot";
        }

    }
    /**
     * build a dependency node
     * <dependency>
     * <groupId>org.springframework.boot</groupId>
     * <artifactId>spring-boot-starter-test</artifactId>
     * </dependency>
     */
    public static class  SpringBootStarterTest extends Dependency{
        @Override
        public String getArtifactId() {
            return "spring-boot-starter-test";
        }

        @Override
        public String getGroupId() {
            return "org.springframework.boot";
        }

    }

    /**
     * build a dependency node
     * <dependency>
     * <groupId>org.apache.dubbo</groupId>
     * <artifactId>dubbo-spring-boot-starter</artifactId>
     * <version>2.6.7</version>
     * </dependency>
     */
    public static class DubboSpringBootStarter extends Dependency{
        Dependency dependency = new Dependency();

        @Override
        public String getArtifactId() {
            return "dubbo-spring-boot-starter";
        }

        @Override
        public String getGroupId() {
            return "org.apache.dubbo";
        }

        @Override
        public String getVersion() {
            return "2.6.7";
        }
    }
}
