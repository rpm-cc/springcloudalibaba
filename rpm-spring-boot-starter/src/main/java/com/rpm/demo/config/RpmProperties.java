package com.rpm.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @author: Piming Ren
 * @date: 2021/6/16 11:12
 * @version: 1.0
 * @description:
 */
@ConfigurationProperties("rpm.demo.coding")
public class RpmProperties {


    private String language;
    private String years;
    private String level;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "RpmConfig{" +
                "language='" + language + '\'' +
                ", years='" + years + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
