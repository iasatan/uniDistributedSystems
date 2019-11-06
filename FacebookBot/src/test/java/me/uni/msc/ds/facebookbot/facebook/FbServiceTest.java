package me.uni.msc.ds.facebookbot.facebook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class FbServiceTest {

    private FbService fbService;

    @BeforeEach
    public void setUp() {
        fbService = new FbService(new RestTemplate(), new FbApiEndpoints());
    }

    @Test
    void response() {
        Assertions.assertEquals("hello", fbService.response("hello"));
        Assertions.assertEquals("nem értem:(", fbService.response("sad"));
    }
}