package com.example.diandioc;

import org.springframework.stereotype.Component;

import java.net.URLEncoder;
@Component
public class UrlEncoder implements IEncoder{
    @Override
    public String encode(String url) {
        return URLEncoder.encode(url);
    }
}
