package com.rpm.demo.io;

import org.yaml.snakeyaml.Yaml;

import java.util.Map;

/**
 * @author: Piming Ren
 * @date: 2021/7/7 17:06
 * @version: 1.0
 * @description:
 */
public class YamlDemo {


    public static void main(String[] args) {
        String astr = "content:\n" +
                "   - item:\n" +
                "      site: www.baidu.com\n" +
                "   - item: \n" +
                "      site: www.taobao.com\n";
        Yaml yaml  = new Yaml();
        Map<String,Object> map = yaml.loadAs(astr,Map.class);
        System.out.println(map);
        System.out.println(yaml.dumpAsMap("{content=[{item={site=www.baidu.com}}, {item={site=www.taobao.com}}]}"));

    }
}
