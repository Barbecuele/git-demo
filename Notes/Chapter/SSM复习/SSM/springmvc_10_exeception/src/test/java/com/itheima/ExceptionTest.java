package com.itheima;

import com.itheima.domain.Book;
import com.itheima.service.impl.BookServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ExceptionTest {

    @Autowired
    private BookServiceImpl bookService;

    @Test
    public void test(){
        Book book = bookService.findById(2);
        System.out.println(book);
    }
}
