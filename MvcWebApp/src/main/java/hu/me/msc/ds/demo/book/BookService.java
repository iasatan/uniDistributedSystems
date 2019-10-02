package hu.me.msc.ds.demo.book;

import java.util.List;

public interface BookService {
    List getAll();

    void add(Book book);
}
