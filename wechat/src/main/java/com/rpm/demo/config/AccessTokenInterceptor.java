package com.rpm.demo.config;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @author: Piming Ren
 * @date: 2021/9/29 11:29
 * @version: 1.0
 * @description:
 */
public class AccessTokenInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        System.out.println(request.getURI());
        return execution.execute(request, body);
    }
}
