package hu.me.msc.ds.hexa.adapter;

import hu.me.msc.ds.hexa.adapter.persist.AuthorEntity;
import hu.me.msc.ds.hexa.adapter.persist.AuthorRepository;
import hu.me.msc.ds.hexa.application.port.out.PersistAuthorPort;
import hu.me.msc.ds.hexa.domain.Author;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorPersistAdapter implements PersistAuthorPort {
    private final AuthorRepository authorRepository;

    @Override
    public void saveAuthor(Author author) {
        AuthorEntity authorEntity = authorRepository.save(new AuthorEntity(null, author.getName()));
        log.debug("entity Saved" + authorEntity);
    }
}
