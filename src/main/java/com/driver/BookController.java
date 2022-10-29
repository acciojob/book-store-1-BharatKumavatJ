package com.driver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // this annotation defines rest apis i will write here
@RequestMapping("books")
public class BookController {

    private List<Book> bookList;
    private int id;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookController(){
        this.bookList = new ArrayList<Book>();
        this.id = 1;
    }

    // post request /create-book
    // pass book as request body
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        // Your code goes here.

        bookList.add(book);
        book.setId(id);
        return  new ResponseEntity<>(book, HttpStatus.CREATED);
    }


    // get request /get-book-by-id/{id}

    // pass id as path variable
    // getBookById()
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
        
        
        Book bookToBeReturned = null;
        
        for(Book book : bookList){
            if(book.getId() == id){
                bookToBeReturned = book;
                break;
            }
        }
        return new ResponseEntity<>(bookToBeReturned, HttpStatus.FOUND);
    }


    // delete request /delete-book-by-id/{id}

    // pass id as path variable
    // deleteBookById()

    @DeleteMapping("/delete-book-by-id/{id}")
    public void deleteBookById(@PathVariable("id") int id){

        for(int i = 0; i < bookList.size(); i++){
            int bookId  = bookList.get(i).getId();
            if(id == bookId){
                bookList.remove(i);
                return;
            }
        }

    }
    // get request /get-all-books
    // getAllBooks()
    @GetMapping("/get-all-books")
    public List<Book> getAllBooks(){
       return bookList;
    }

    // delete request /delete-all-books
    // deleteAllBooks()
    @DeleteMapping("/delete-all-books")
    public void deleteAllBooks(){
        bookList = null;

    }

    // get request /get-books-by-author
    // pass author name as request param
    // getBooksByAuthor()
    @GetMapping("/get-books-by-author")
    public Book getBooksByAuthor(@RequestParam("authName")String authName){
        for(int i = 0; i < bookList.size(); i++){
            String bookAuthName = bookList.get(i).getAuthor();
            if(bookAuthName.compareTo(authName) == 0) return bookList.get(i);
        }
        return null;
    }

    // get request /get-books-by-genre
    // pass genre name as request param
    // getBooksByGenre()
    @GetMapping("/get-books-by-genre")
    public Book getBooksByGenre(@RequestParam("genre")String genre){
        for(int i = 0; i < bookList.size(); i++){
            String bookGenre = bookList.get(i).getGenre();
            if(bookGenre.compareTo(genre) == 0) return bookList.get(i);
        }
        return null;
    }
}
