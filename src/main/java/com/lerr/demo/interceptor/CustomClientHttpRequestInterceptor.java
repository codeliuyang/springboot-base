package com.lerr.demo.interceptor;

import com.google.common.base.Charsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 自定义扩展拦截器，可以增加日志打印或者请求头统一处理
 *
 * @author yangliu
 */
public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomClientHttpRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        traceRequest(httpRequest, bytes);
        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, bytes);
        traceResponse(response);
        return response;
    }


    private void traceRequest(HttpRequest request, byte[] bytes) {
        LOGGER.info("===========================request begin================================================");
        LOGGER.info("URI         : {}", request.getURI());
        LOGGER.info("Method      : {}", request.getMethod());
        LOGGER.info("Headers     : {}", request.getHeaders());
        LOGGER.info("Request body: {}", new String(bytes, Charsets.UTF_8));
        LOGGER.info("==========================request end================================================");
    }

    private void traceResponse(ClientHttpResponse response) throws IOException {
        StringBuilder inputStringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(), Charsets.UTF_8));
        String line = bufferedReader.readLine();
        while (line != null) {
            inputStringBuilder.append(line);
            inputStringBuilder.append('\n');
            line = bufferedReader.readLine();
        }
        LOGGER.info("============================response begin==========================================");
        LOGGER.info("Status code  : {}", response.getStatusCode());
        LOGGER.info("Status text  : {}", response.getStatusText());
        LOGGER.info("Headers      : {}", response.getHeaders());
        LOGGER.info("Response body: {}", inputStringBuilder.toString());
        LOGGER.info("=======================response end=================================================");
    }



}
