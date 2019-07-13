package com.htg.adshow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@EnableFeignClients("com.htg")
@EnableDiscoveryClient
@PropertySource(encoding = "UTF-8", value = {"classpath:config/mqtt.properties"})
@MapperScan("com.htg.adshow.mapper")
@SpringBootApplication
public class AdshowApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdshowApplication.class);
    }
}
