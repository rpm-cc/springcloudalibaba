package com.rpm.demo.common;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author PimingRen
 * @Date 2021/3/31
 * @Version 1.0
 *
 * 可以使用代码的方式，去获得 一个jar 包的版本号。
 */
public final class Version {


    private Version() {
    }


    private static final Logger logger = LogManager.getLogger(Version.class);
    private static final Pattern VERSION_PATTERN = Pattern.compile("([0-9][0-9\\.\\-]*\\.jar)");
    private static final String VERSION = getVersion(Version.class,"2.0.0");

    public static String getVersion(){
        return VERSION;
    }
    public static String getVersion(Class cls, String defaultVersion) {

        try {
            String version = cls.getPackage().getImplementationVersion();
            if (version == null || version.length() == 0) {
                version = cls.getPackage().getSpecificationVersion();
            }
            if (version == null || version.length() == 0) {
                String file = cls.getProtectionDomain().getCodeSource().getLocation().getFile();
                if (file != null && file.length() > 0 && file.endsWith(".jar")) {
                    Matcher matcher = VERSION_PATTERN.matcher(file);
                    while (matcher.find() && matcher.groupCount() > 0) {
                        version = matcher.group(1);
                    }
                }
            }
            return version == null || version.length() == 0 ? defaultVersion : version;

        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
            return defaultVersion;
        }

    }


    public static void main(String[] args) {
        System.out.println(Version.getVersion(ConsumerRecord.class,"1.0.0"));
    }
}
