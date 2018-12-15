package com.bben.medical.service;

import com.bben.medical.model.medical.Book;

import java.util.List;

/**
 * Book 业务接口层
 */
public interface BookService {
    /**
     * 获取所有 Book
     */
    List<Book> findAll();

    /**
     * 新增 Book
     *
     * @param book {@link Book}
     */
    Book insertByBook(Book book);

    /**
     * 更新 Book
     *
     * @param book {@link Book}
     */
    Book update(Book book);

    /**
     * 删除 Book
     *
     * @param id 编号
     */
    Integer delete(Integer id);

    /**
     * 获取 Book
     *
     * @param id 编号
     */
    Book findById(Integer id);
}
