package com.rpm.demo.mail.service;


import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Piming Ren
 * @date: 2021/6/17 11:03
 * @version: 1.0
 * @description:
 */
public class HtmlBuilder {

    private static String DEFAULT_PATH = "templates/";
    private static String DEFAULT_ENCODING = "UTF-8";
    private static String DEFAULT_TEXT = "content";
    private static String DEFAULE_FILE_NAME="default.ftl";
    private String templatePath;
    private String encoding;
    private String templateFileName;
    private Map data;

    private HtmlBuilder(){
        encoding = DEFAULT_ENCODING;
        templatePath = this.getClass().getClassLoader().getResource(DEFAULT_PATH).getPath();
        templateFileName = DEFAULE_FILE_NAME;
    }
    public static HtmlBuilder create(){
        return  new HtmlBuilder();
    }
    public HtmlBuilder encoding(String encoding){
        this.encoding = encoding;
        return this;
    }
    public HtmlBuilder templatePath(String templatePath){
        this.templatePath = encoding;
        return this;
    }
    public HtmlBuilder templateFileName(String templateFileName){
        this.templateFileName = templateFileName;
        return this;
    }
    /**
     * 默认方式 发送文本内容
     * ruguo  text(text) and data(data)  同时使用。
     * key DEFAULT_TEXT 中的值以text优先
     * 这两个方法还是有写冲突的 。建议只是用一种方法。不要两个方法一起用
     * @param text priority hight
     * @return
     */
    public HtmlBuilder text(String text) {
        if (data == null) {
            data = new HashMap<>(1);
        }
        data.put(DEFAULT_TEXT, text);
        return this;

    }

    /**
     * 直接赋值
     * @param data
     * @return
     */
    public HtmlBuilder data(Map<String, Object> data) {
        if (this.data ==null) {
            this.data = data;
        }else {
            // text value priority height ,remove use text
            if(data.containsKey(DEFAULT_TEXT)) {
                data.remove(DEFAULT_TEXT);
            }
            this.data.putAll(data);
        }
        return this;

    }

    /**
     * 对应freemarker中的模板
     * @return
     */
    public String html() {
        StringWriter stringWriter = new StringWriter();
        try {
            Template template = configuration().getTemplate(templateFileName, encoding);
            template.process(data, stringWriter);
            stringWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

    public Configuration configuration() throws IOException {
        FileTemplateLoader fileTemplateLoader = new FileTemplateLoader(new File(templatePath));
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
        configuration.setTemplateLoader(fileTemplateLoader);
        return configuration;
    }

    /**
     * 有需要特别指定templates放置目录。
     *
     * @param path
     * @return
     */
    public HtmlBuilder setTemplatePath(String path) {
        this.templatePath = this.getClass().getClassLoader().getResource(path).getPath();
        return this;
    }

    /**
     * 有需要特别字符编码的
     *
     * @param encoding
     * @return
     */
    public HtmlBuilder setEncoding(String encoding) {
        this.encoding = encoding;
        return this;
    }


    public static void main(String[] args) {
        Map<String,Object> data  = new HashMap<>(1);
        data.put(DEFAULT_TEXT,"data 的赋值");
        String text  = HtmlBuilder.create().text("text 的赋值").templateFileName("email.ftl").html();
        System.out.println(text);
    }
}
