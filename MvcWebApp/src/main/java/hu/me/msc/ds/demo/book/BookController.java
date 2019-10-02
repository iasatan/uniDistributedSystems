package hu.me.msc.ds.demo.book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("book")
@Slf4j
public class BookController {

    @Value("${spring.application.name}")
    private String appName;

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("getbooks")
    public ModelAndView getBooks() {
        List<Book> bookList = bookService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bookList", bookList);
        modelAndView.addObject("appName", appName);
        modelAndView.setViewName("bookList");
        return modelAndView;
    }

    @GetMapping("bookForm")
    public ModelAndView bookForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("book", new Book());
        modelAndView.setViewName("addBook");
        return modelAndView;
    }

    @PostMapping("addBook")
    public ModelAndView addBook(@Valid Book book, BindingResult bindingResult) {
        log.debug("Book jött{}", book);
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("book", book);
            modelAndView.setViewName("addBook");
        } else {
            bookService.add(book);
            modelAndView.setViewName("redirect:/book/getbooks");
        }

        return modelAndView;
    }
}
