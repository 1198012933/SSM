package com.feng.service;

import com.feng.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    int addBook(Books book);
    int deleteBookById(int id);
    int updateBook(Books book);
    Books queryBookById(int id);
    List<Books> queryAllBook();
    Books queryBookByName(String bookName);
}
