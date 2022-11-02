package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.createBook(book);
    }

    public Book getBookById(int id) {
        return bookRepository.getBookById(id);
    }

    public List<Book> getAllBooks() {

        return bookRepository.getAllBooks();

    }

    public Book getBookByAuthor(String author) {
        return bookRepository.getBookByAuthor(author);
    }

    public Book getBookByGenre(String genre) {
        return bookRepository.getBookByGenre(genre);

    }

    public void deleteBookById(int id) {
        bookRepository.deleteBookById(id);
    }
    public void DeleteAllBooks(){
        bookRepository.DeleteAllBooks();
    }
}





















