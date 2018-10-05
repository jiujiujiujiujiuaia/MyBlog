package com.blog.core.util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RestClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestClient.class.getName());
    protected static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.10 Safari/537.36";

    public static HttpResponse sendGet(String url) throws UnirestException {
        LOGGER.debug("request url info : {}", url);
        HttpResponse<String> response = Unirest.get(url)
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("User-Agent",USER_AGENT)
                .header("Accept-Charset","uft-8")
                .asString();
        LOGGER.debug("response status info : {}", response.getStatus());
        LOGGER.debug("response status message info : {}", response.getStatusText());
        return response;
    }

    public static void main(String[] args)throws UnirestException{

    }
}
