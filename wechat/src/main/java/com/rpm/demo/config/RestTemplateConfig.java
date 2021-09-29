package com.rpm.demo.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/29 9:20
 * @version: 1.0
 * @description:
 */
@Configuration
public class RestTemplateConfig {


    @Bean
    public RestTemplate restTemplate() {

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        //设置超时时间 。
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(3000);
        RestTemplate restTemplate = new RestTemplate(factory);

        List<HttpMessageConverter<?>> httpMessageConverterList = restTemplate.getMessageConverters();
        Iterator<HttpMessageConverter<?>> iterator = httpMessageConverterList.iterator();
        while (iterator.hasNext()) {
            HttpMessageConverter<?> converter = iterator.next();
            if (converter instanceof StringHttpMessageConverter) {
                iterator.remove();
            }
            if (converter instanceof GsonHttpMessageConverter || converter instanceof MappingJackson2HttpMessageConverter) {
                iterator.remove();
            }
        }
        //HttpMessageConverter
        FastJsonHttpMessageConverter messageConverter = new FastJsonHttpMessageConverter();
        //设置转化配置 这里暂时不做设置
        //FastJsonConfig config  = new FastJsonConfig();
        //config.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        //messageConverter.setFastJsonConfig(config);

        //强制设置MediaType
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);
        messageConverter.setSupportedMediaTypes(supportedMediaTypes);
        httpMessageConverterList.add(messageConverter);
        httpMessageConverterList.add(0, new StringHttpMessageConverter(Charset.forName("utf-8")));

        //请求头设置
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));

        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

}
