package hu.me.msc.ds.hexa.application.service;

import hu.me.msc.ds.hexa.application.port.in.RegisterAuthorUseCase;
import hu.me.msc.ds.hexa.application.port.out.PersistAuthorPort;
import hu.me.msc.ds.hexa.common.UseCase;
import hu.me.msc.ds.hexa.domain.Author;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@UseCase
@Slf4j
public class RegisterAuthorService implements RegisterAuthorUseCase {
    private final PersistAuthorPort persistAuthorPort;

    @Override
    public void registerAuthor(RegisterAuthorCommand command) {
        log.debug("incomming registerAuthor " + command);
        persistAuthorPort.saveAuthor(new Author(command.getName()));
    }
}
