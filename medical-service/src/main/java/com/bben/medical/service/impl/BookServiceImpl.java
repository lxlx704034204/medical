package com.bben.medical.service.impl;

import com.bben.medical.mapper.medical.BookMapper;
import com.bben.medical.model.medical.Book;
import com.bben.medical.model.medical.BookExample;
import com.bben.medical.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Book 业务层实现
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;//这里会报错，但是并不会影响

    @Override
    public List<Book> findAll() {
        BookExample bookExample = new BookExample();
//        BookExample.Criteria criteria = bookExample.createCriteria();

        List<Book> listBook = bookMapper.selectByExample(bookExample);

        return listBook;
    }

    @Override
    public Book insertByBook(Book book) {
        int count = bookMapper.insertSelective(book);
        if (count == 0) {
            return null;
        }

        return book;
    }

    @Override
    public Book update(Book book) {
        int count = bookMapper.updateByPrimaryKeySelective(book);
        if (count == 0) {
            return null;
        }

        return book;
    }

    @Override
    public Integer delete(Integer id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Book findById(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }
}
