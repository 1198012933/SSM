package com.feng.controller;

import com.feng.pojo.Books;
import com.feng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }
    @RequestMapping("toAddBook")
    public String toAddBook(){
        return "addBook";
    }
    @RequestMapping("addBook")
    public String addBook(Books books){
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }
    @RequestMapping("toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("book",books);
        return "updateBook";
    }
    @RequestMapping("updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }
    @RequestMapping("del/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
    @RequestMapping("queryBook")
    public String queryBook(String queryName,Model model){
        Books books = bookService.queryBookByName(queryName);
        List<Books> list = new ArrayList<>();
        list.add(books);
        if (books == null){
            list = bookService.queryAllBook();
            model.addAttribute("erro","未查到");
        }
        model.addAttribute("list",list);
        return "allBook";
    }
}
