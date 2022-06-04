package com.itheima;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void testGetById() {
        Book book = bookService.findById(2);
        System.out.println(book);
    }

    @Test
    void testGetAll(){
        List<Book> all = bookService.findAll();
        System.out.println(all);
    }
}
