package me.uni.msc.ds.facebookbot.facebook;

import me.uni.msc.ds.facebookbot.facebook.models.Event;
import me.uni.msc.ds.facebookbot.facebook.models.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RobotServiceTest {

    private RobotService fbService;

    @BeforeEach
    public void setUp() {
        fbService = new RobotService();
    }

    @Test
    void response() {
        Assertions.assertEquals("hello", fbService.response(new Event().setMessage(new Message().setText("hello"))));
        Assertions.assertEquals("nem értem:(", fbService.response(new Event().setMessage(new Message().setText("asd"))));
    }
}