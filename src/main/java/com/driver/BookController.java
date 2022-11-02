package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody() Book book){

        Book bookObj = bookService.createBook(book);

        return new ResponseEntity<>(bookObj, HttpStatus.OK);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id){

        int id_ = Integer.parseInt(id);
        return new ResponseEntity<>(bookService.getBookById(id_), HttpStatus.OK);
    }

    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getBookList(){
        List<Book> allBooks = bookService.getAllBooks();
        return  new ResponseEntity<>(allBooks, HttpStatus.OK);
    }



    @GetMapping("/get-books-by-author")
    public ResponseEntity<Book> getBooksByAuthor(@RequestParam("author") String author){
        Book book = bookService.getBookByAuthor(author);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/get-books-by-genre")
    public ResponseEntity<Book> getBooksByGenre(@RequestParam("genre") String genre){
        Book book = bookService.getBookByGenre(genre);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable String id_){
        int id = Integer.parseInt(id_);
        bookService.deleteBookById(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @DeleteMapping("delete-all-books")
    public ResponseEntity<String> DeleteAllBooks(){
        bookService.DeleteAllBooks();
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
