package hu.me.msc.ds.hexa.application.port.out;

import hu.me.msc.ds.hexa.domain.Author;

public interface PersistAuthorPort {

    void saveAuthor(Author author);
}
