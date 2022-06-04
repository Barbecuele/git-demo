package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public String save(@RequestBody Book book){
        System.out.println("book save ==>" + book);

        return "{'module':'book save success!'}";
    }

    @GetMapping
    public List<Book> getAll(){

        System.out.println("book getAll is Running!");
        Book book1 = new Book();
        book1.setType("Java");
        book1.setName("Think of Java");
        book1.setId(1);
        book1.setDescription("Study Java");

        Book book2 = new Book();
        book2.setType("C#");
        book2.setName("Think of C#");
        book2.setId(2);
        book2.setDescription("Study C#");

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        return bookList;
    }
}
