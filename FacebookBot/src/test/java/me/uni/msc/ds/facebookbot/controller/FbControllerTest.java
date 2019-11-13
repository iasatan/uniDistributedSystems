package me.uni.msc.ds.facebookbot.controller;

import me.uni.msc.ds.facebookbot.common.EventType;
import me.uni.msc.ds.facebookbot.facebook.models.Event;
import me.uni.msc.ds.facebookbot.facebook.models.Message;
import me.uni.msc.ds.facebookbot.facebook.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@SpringBootTest
class FbControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private FbController fbController;
    Event event;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @BeforeEach
    public void setUp() {
        event = new Event();
        event.setType(EventType.MESSAGE);
        event.setMessage(new Message().setText("asd"));
        event.setSender(new User().setContactName("Adam"));
    }


    @Test
    public void givenGreetURI_whenMockMVC_thenVerifyResponse() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/hello").param("message", "asd"))
                .andDo(print()).andExpect(status().isOk())

                //.andExpect(jsonPath("$.message").value("hello "))
                .andReturn();

        Assertions.assertEquals("application/json",
                mvcResult.getResponse().getContentType());
    }


}