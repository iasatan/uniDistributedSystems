package me.uni.msc.ds.facebookbot.facebook;

import me.uni.msc.ds.facebookbot.facebook.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author rpatra16
 * @since 30/08/2018
 */
@Service
public class FbService {
    private final RestTemplate restTemplate;
    private final WebClient webClient;
    private final FbApiEndpoints fbApiEndpoints;

    public FbService(RestTemplate restTemplate, FbApiEndpoints fbApiEndpoints, WebClient webClient) {
        this.restTemplate = restTemplate;
        this.fbApiEndpoints = fbApiEndpoints;
        this.webClient = webClient;
    }

    public User getUser(String id, String pageAccessToken) {
        return webClient.get().uri(fbApiEndpoints.getUserApi()).
        return restTemplate.getForEntity(fbApiEndpoints.getUserApi(), User.class, id, pageAccessToken).getBody();
    }


}
