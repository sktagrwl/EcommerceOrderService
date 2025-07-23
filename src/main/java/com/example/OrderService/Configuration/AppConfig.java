package com.example.OrderService.Configuration;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}


// Adding load balanced on a rest template enables client-side load balancing

//it is now smart enough to intercept the local service name and resolve them int actual instances URLs from Eureka