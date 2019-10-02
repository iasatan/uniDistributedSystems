package hu.me.msc.ds.demo;

import hu.me.msc.ds.demo.book.BookService;
import hu.me.msc.ds.demo.book.BookServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public BookService getBookService() {
        return new BookServiceImpl();
    }

}
