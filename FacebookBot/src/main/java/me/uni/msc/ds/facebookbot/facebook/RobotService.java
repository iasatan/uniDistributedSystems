package me.uni.msc.ds.facebookbot.facebook;

import me.uni.msc.ds.facebookbot.facebook.models.Event;
import org.springframework.stereotype.Service;

@Service
public class RobotService {
    public String response(Event event) {
        System.out.println(event.toString());
        switch (event.getMessage().getText()) {
            case "hello":
                System.out.println("hello");
                return "hello";
        }
        return "nem értem:(";
    }
}
