package me.uni.msc.ds.facebookbot.controller;

import me.uni.msc.ds.facebookbot.common.Controller;
import me.uni.msc.ds.facebookbot.common.EventType;
import me.uni.msc.ds.facebookbot.common.JBot;
import me.uni.msc.ds.facebookbot.facebook.Bot;
import me.uni.msc.ds.facebookbot.facebook.FbService;
import me.uni.msc.ds.facebookbot.facebook.models.Event;
import me.uni.msc.ds.facebookbot.facebook.models.Message;
import me.uni.msc.ds.facebookbot.facebook.models.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

@JBot
@Profile("facebook")
public class FbController extends Bot {


    private FbService fbService;


    @Value("${fbBotToken}")
    private String fbToken;

    @Value("${fbPageAccessToken}")
    private String pageAccessToken;

    @Autowired
    public FbController(FbService fbService) {
        this.fbService = fbService;
    }


    @Override
    public String getFbToken() {
        return fbToken;
    }

    @Override
    public String getPageAccessToken() {
        return pageAccessToken;
    }

    public void init() {
        setGetStartedButton("hi");
        setGreetingText(new Payload[]{new Payload().setLocale("default").setText("JBot is a Java Framework to help" +
                " developers make Facebook, and Slack bots easily. You can see a quick demo by clicking " +
                "the \"Get Started\" button or just typing \"Hi\".")});
    }

    /**
     * This method gets invoked when a user clicks on the "Get Started" button or just when someone simply types
     * hi, hello or hey. When it is the former, the event type is {@code EventType.POSTBACK} with the payload "hi"
     * and when latter, the event type is {@code EventType.MESSAGE}.
     *
     * @param event
     */
    @Controller(events = {EventType.MESSAGE, EventType.POSTBACK})
    public void onGetStarted(Event event) {
        reply(event, new Message().setText(fbService.response(event.getMessage().getText())));
    }

/**
 * This method gets invoked when the user clicks on a quick reply button whose payload is either "yes" or "no".
 *
 * @param event
 */
    /*
    @Controller(events = EventType.QUICK_REPLY, pattern = "(yes|no)")
    public void onReceiveQuickReply(Event event) {
        if ("yes".equals(event.getMessage().getQuickReply().getPayload())) {
            reply(event, "Cool! You can type: \n - Show Buttons \n - Show List \n - Setup meeting");
        } else {
            reply(event, "See you soon!");
        }
    }

    /**
     * This method is invoked when the user types "Show Buttons" or something which has "button" in it as defined
     * in the {@code pattern}.
     *
     * @param event
     */
    /*
    @Controller(events = EventType.MESSAGE, pattern = "(?i:button)")
    public void showButtons(Event event) {
        Button[] buttons = new Button[]{
                new Button().setType("web_url").setUrl("http://blog.ramswaroop.me").setTitle("JBot Docs"),
                new Button().setType("web_url").setUrl("https://goo.gl/uKrJWX").setTitle("Buttom Template")
        };
        reply(event, new Message().setAttachment(new Attachment().setType("template").setPayload(new Payload()
                .setTemplateType("button").setText("These are 2 link buttons.").setButtons(buttons))));
    }

    /**
     * This method is invoked when the user types "Show List" or something which has "list" in it as defined
     * in the {@code pattern}.
     *
     * @param event
     */
    /*
    @Controller(events = EventType.MESSAGE, pattern = "(?i:list)")
    public void showList(Event event) {
        Element[] elements = new Element[]{
                new Element().setTitle("AnimateScroll").setSubtitle("A jQuery Plugin for Animating Scroll.")
                        .setImageUrl("https://plugins.compzets.com/images/as-logo.png")
                        .setDefaultAction(new Button().setType("web_url").setMessengerExtensions(true)
                        .setUrl("https://plugins.compzets.com/animatescroll/")),
                new Element().setTitle("Windows on Top").setSubtitle("Keeps a specific Window on Top of all others.")
                        .setImageUrl("https://plugins.compzets.com/images/compzets-logo.png")
                        .setDefaultAction(new Button().setType("web_url").setMessengerExtensions(true)
                        .setUrl("https://www.compzets.com/view-upload.php?id=702&action=view")),
                new Element().setTitle("SimpleFill").setSubtitle("Simplest form filler ever.")
                        .setImageUrl("https://plugins.compzets.com/simplefill/chrome-extension/icon-64.png")
                        .setDefaultAction(new Button().setType("web_url").setMessengerExtensions(true)
                        .setUrl("https://plugins.compzets.com/simplefill/"))
        };
        reply(event, new Message().setAttachment(new Attachment().setType("template").setPayload(new Payload()
                .setTemplateType("list").setElements(elements))));
    }

    /**
     * Show the github project url when the user says bye.
     *
     * @param event
     */
    /*
    @Controller(events = EventType.MESSAGE, pattern = "(?i)(bye|tata|ttyl|cya|see you)")
    public void showGithubLink(Event event) {
        reply(event, new Message().setAttachment(new Attachment().setType("template").setPayload(new Payload()
                .setTemplateType("button").setText("Bye. Happy coding!").setButtons(new Button[]{new Button()
                        .setType("web_url").setTitle("View code").setUrl("https://github.com/ramswaroop/jbot")}))));
    }


    // Conversation feature of JBot

    /**
     * Type "setup meeting" to start a conversation with the bot. Provide the name of the next method to be
     * invoked in {@code next}. This method is the starting point of the conversation (as it
     * calls {@link Bot#startConversation(Event, String)} within it. You can chain methods which will be invoked
     * one after the other leading to a conversation.
     *
     * @param event
     */
    /*
    @Controller(pattern = "(?i)(setup meeting)", next = "confirmTiming")
    public void setupMeeting(Event event) {
        startConversation(event, "confirmTiming");   // start conversation
        reply(event, "Cool! At what time (ex. 15:30) do you want me to set up the meeting?");
    }

    /**
     * This method will be invoked after {@link FbBot#setupMeeting(Event)}. You need to
     * call {@link Bot#nextConversation(Event)} to jump to the next question in the conversation.
     *
     * @param event
     */
    /*
    @Controller(next = "askTimeForMeeting")
    public void confirmTiming(Event event) {
        reply(event, "Your meeting is set at " + event.getMessage().getText() +
                ". Would you like to repeat it tomorrow?");
        nextConversation(event);    // jump to next question in conversation
    }

    /**
     * This method will be invoked after {@link FbBot#confirmTiming(Event)}. You can
     * call {@link Bot#stopConversation(Event)} to end the conversation.
     *
     * @param event
     */
    /*
    @Controller(next = "askWhetherToRepeat")
    public void askTimeForMeeting(Event event) {
        if (event.getMessage().getText().contains("yes")) {
            reply(event, "Okay. Would you like me to set a reminder for you?");
            nextConversation(event);    // jump to next question in conversation
        } else {
            reply(event, "No problem. You can always schedule one with 'setup meeting' command.");
            stopConversation(event);    // stop conversation only if user says no
        }
    }

    /**
     * This method will be invoked after {@link FbBot#askTimeForMeeting(Event)}. You can
     * call {@link Bot#stopConversation(Event)} to end the conversation.
     *
     * @param event
     */
    /*
    @Controller
    public void askWhetherToRepeat(Event event) {
        if (event.getMessage().getText().contains("yes")) {
            reply(event, "Great! I will remind you tomorrow before the meeting.");
        } else {
            reply(event, "Okay, don't forget to attend the meeting tomorrow :)");
        }
        stopConversation(event);    // stop conversation
    }

     */
}