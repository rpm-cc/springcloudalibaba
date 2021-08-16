package com.rpm.wechat.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Piming Ren
 * @Date 2021/1/25 15:08
 * @Version 1.0
 */
public class HttpUtil {

    private static Logger logger = LogManager.getLogger("com.rpm.wechat.util.HttpUtil");

    /**
     * @param url
     * @param params  BasicNameValuePair implement  NameValuePaire
     * @param headers BasicHeader   implement  Header
     * @return
     */
    public static String formPost(String url, List<NameValuePair> params, List<Header> headers) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            URIBuilder uriBuilder = new URIBuilder(url).setParameters();
            if (params != null) {
                uriBuilder.addParameters(params);
            }
            URI uri = uriBuilder.build();
            HttpPost httpPost = new HttpPost(uri);
            if (headers != null) {
                for (Header header : headers) {
                    httpPost.setHeader(header);
                }
            }
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            return httpclient.execute(httpPost, responseHandler);


        } catch (URISyntaxException e) {
            logger.error("URISyntaxException:{}", e);
        } catch (IOException e) {
            logger.error("IOException:{}", e);
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.error("IOException  close:{}", e);
            }
        }

        return "{\"errcode\":\"0\"}";

    }

    /**
     * @param url
     * @param json    Json str  using map
     * @param headers BasicHeader   implement  Header
     * @return
     */
    public static String jsonPost(String url, String json, List<Header> headers) {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            URIBuilder uriBuilder = new URIBuilder(url).setParameters();
            URI uri = uriBuilder.build();
            HttpPost httpPost = new HttpPost(uri);
            if (headers != null) {
                for (Header header : headers) {
                    httpPost.setHeader(header);
                }
            }
            httpPost.addHeader("content-type", ContentType.APPLICATION_JSON.getMimeType());
            if (json != null) {
                // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
                StringEntity entity = new StringEntity(json, "UTF-8");
                httpPost.setEntity(entity);
            }
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            return httpclient.execute(httpPost, responseHandler);

        } catch (URISyntaxException e) {
            logger.error("URISyntaxException:{}", e);
        } catch (IOException e) {
            logger.error("IOException:{}", e);
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.error("IOException close:{}", e);
            }
        }
        return "{\"errcode\":\"0\"}";
    }

    /**
     * @param url
     * @param params  BasicNameValuePair implement  NameValuePaire
     * @param headers BasicHeader   implement  Header
     * @return
     */
    public static String get(String url, List<NameValuePair> params, List<Header> headers) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            URIBuilder uriBuilder = new URIBuilder(url).setParameters();
            if (params != null) {
                uriBuilder.addParameters(params);
            }
            URI uri = uriBuilder.build();
            HttpPost httpPost = new HttpPost(uri);
            if (headers != null) {
                for (Header header : headers) {
                    httpPost.setHeader(header);
                }
            }
            HttpGet httpget = new HttpGet(uri);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String msg = httpclient.execute(httpget, responseHandler);
            System.out.println(msg);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }


    public static void main(String[] args) {
        String url = "http://localhost:8080/api/hde/dict/listDict";
        Map<String, Object> params = new HashMap<>();
        params.put("pageNum", 1);
        params.put("pageSize", 10);
        RestTemplate template = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
        template.setInterceptors(interceptors);
        final ResponseEntity<String> entity = template.postForEntity(url, JSON.toJSONString(params), String.class);
        String response = entity.getBody();
        JSONObject object = JSON.parseObject(response);
        Object obj = object.get("pageInfo");;
    }


}
