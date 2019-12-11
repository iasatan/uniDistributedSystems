package hu.me.msc.ds.hexa.adapter.integration;

import hu.me.msc.ds.hexa.application.port.in.RegisterAuthorUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint
@Slf4j
@RequiredArgsConstructor
public class RegisterAuthorActivator {
    private final RegisterAuthorUseCase registerAuthorUseCase;

    @ServiceActivator(inputChannel = "authorChannel")
    public void registerAuthor(Message<RegisterAuthorUseCase.RegisterAuthorCommand> msg) {
        RegisterAuthorUseCase.RegisterAuthorCommand payload = msg.getPayload();
        log.debug(payload.toString() + " is coming");
        registerAuthorUseCase.registerAuthor(payload);
    }
}
