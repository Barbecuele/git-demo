package com.itheima.service.impl;

import com.itheima.controller.Code;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public boolean save(Book book) {
        return bookDao.save(book) > 0;
    }

    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }

    public boolean delete(Integer id) {
        return bookDao.delete(id) > 0;
    }

    public Book findById(Integer id) {

        if (id == 1) {
            throw new BusinessException(Code.BUSINESS_ERR, "真是拿你没办法");
        }
        //将可能出现的异常进行包装，转换成自定义异常
//        try {
//            int i = 1 / 0;
//        } catch (ArithmeticException e) {
//            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR, "服务器访问超时");
//        }
        return bookDao.findById(id);
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }
}
