package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepository {


    public BookRepository() {}

    private static int id = 0;
    private List<Book> bookDb = new ArrayList<>();

    public Book createBook(Book book) {
        id++;
        Book newBook = new Book(id, book.getName(), book.getGenre(),  book.getAuthor());
        bookDb.add(newBook);
        return newBook;
    }

    public Book getBookById(int id) {

        for(Book book : bookDb){
            int bookId = book.getId();
            if(bookId == id) return book;
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return bookDb;
    }

    public Book getBookByAuthor(String author) {
        for(Book book : bookDb){
            String bookAuthor = book.getAuthor();
            if(bookAuthor.compareTo(author) == 0) return book;
        }
        return null;
    }

    public Book getBookByGenre(String genre) {
        for(Book book : bookDb){
            String bookGenre = book.getGenre();
            if(bookGenre.compareTo(genre) == 0) return book;
        }
        return null;
    }

    public void deleteBookById(int id) {
        for(int i = 0; i < bookDb.size(); i++){
            if(bookDb.get(i).getId() == id){
                bookDb.remove(i);
                return;
            }
        }
    }
    public void DeleteAllBooks(){
        bookDb = new ArrayList<>();
        id = 0;
    }
}
