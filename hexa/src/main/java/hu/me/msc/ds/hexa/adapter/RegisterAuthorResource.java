package hu.me.msc.ds.hexa.adapter;

import hu.me.msc.ds.hexa.application.port.in.RegisterAuthorUseCase;
import lombok.Data;

@Data
public class RegisterAuthorResource {
    private String name;

    public RegisterAuthorUseCase.RegisterAuthorCommand toCommand() {
        return new RegisterAuthorUseCase.RegisterAuthorCommand(name);
    }
}
