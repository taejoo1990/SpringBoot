package com.example.diandioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;


@SpringBootApplication
public class DiAndIocApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiAndIocApplication.class, args);
        ApplicationContext context = ApplicationContextProvider.getContext();
        Encode base64Encoder = new Encode(context.getBean(Base64Encoder.class));
        Encode urlEncoder = new Encode(context.getBean(UrlEncoder.class));
        String url = "www.google.com/books/it?page=2&size=10";
        String base64Result = base64Encoder.getiEncoder().encode(url);
        String urlResult = urlEncoder.getiEncoder().encode(url);
        System.out.println("base64Result = " + base64Result);
        System.out.println("urlResult = " + urlResult);
    }
}
    @Configuration
    class AppConfig{

        @Bean("base64Encode")
        public Encode encoder(Base64Encoder base64Encoder){
            return new Encode(base64Encoder);
        }
        @Bean("urlEncode")
        public Encode encoder(UrlEncoder urlEncoder){
            return new Encode(urlEncoder);
        }
    }


