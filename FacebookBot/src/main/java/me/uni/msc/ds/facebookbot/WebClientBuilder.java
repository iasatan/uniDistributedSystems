package me.uni.msc.ds.facebookbot;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientBuilder {
    public WebClient build(String url) {
        return WebClient.create(url);
    }

    public String getResponse(String url) {
        return build(url).get().exchange().block().bodyToMono(String.class).block();
    }
}
