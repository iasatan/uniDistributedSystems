package hu.me.msc.ds.hexa.adapter.web;

import hu.me.msc.ds.hexa.adapter.RegisterAuthorResource;
import hu.me.msc.ds.hexa.application.port.in.RegisterAuthorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterAuthorController {

    private final RegisterAuthorUseCase registerAuthorUseCase;

    @PostMapping("authors/register")
    void register(@RequestBody RegisterAuthorResource resource) {
        registerAuthorUseCase.registerAuthor(resource.toCommand());
    }
}
