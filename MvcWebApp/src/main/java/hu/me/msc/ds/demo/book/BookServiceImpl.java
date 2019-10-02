package hu.me.msc.ds.demo.book;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    private List<Book> bookList = new ArrayList<>();

    @PostConstruct
    void postContruct() {
        this.bookList.add(new Book.BookBuilder()
                .title("ads")
                .author("Adam")
                .isbn(2).build());
        this.bookList.add(new Book.BookBuilder()
                .title("qwe")
                .author("Adam")
                .isbn(3).build());
        this.bookList.add(new Book.BookBuilder()
                .title("rtz")
                .author("Adam")
                .isbn(4).build());
    }

    @Override
    public List getAll() {
        return bookList;
    }

    @Override
    public void add(Book book) {
        bookList.add(book);
    }
}
