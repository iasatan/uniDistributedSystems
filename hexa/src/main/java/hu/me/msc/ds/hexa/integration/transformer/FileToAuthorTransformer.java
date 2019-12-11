package hu.me.msc.ds.hexa.integration.transformer;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.me.msc.ds.hexa.adapter.RegisterAuthorResource;
import hu.me.msc.ds.hexa.application.port.in.RegisterAuthorUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@MessageEndpoint
@Slf4j
public class FileToAuthorTransformer {
    @Transformer(inputChannel = "authorFileNameChannel", outputChannel = "authorChannel")
    RegisterAuthorUseCase.RegisterAuthorCommand transform(Message<File> msg) throws IOException {
        File payload = msg.getPayload();
        log.debug("incoming filename" + payload.toString());
        byte[] jsonData = Files.readAllBytes(payload.toPath());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonData, RegisterAuthorResource.class).toCommand();
    }

}
