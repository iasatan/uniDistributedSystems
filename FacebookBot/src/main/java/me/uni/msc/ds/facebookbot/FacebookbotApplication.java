package me.uni.msc.ds.facebookbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication(scanBasePackages = "me.uni.msc.ds.facebookbot")
public class FacebookbotApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacebookbotApplication.class, args);
    }

    @Bean
    public WebClient webClient(String url) {
        return WebClient.builder().baseUrl(url).build();
    }

    @Bean
    public String getUrl() {
        return "localhost:8080";
    }


}
