package com.theveloper.bookmanager.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BookService bookService;


    //MyBooks
    @RequestMapping("/books")
    public List<Book> getAllMyBooks(){
       return bookService.getAllMyBooks();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public void addMyBook(@RequestBody Book book){
        bookService.addBookToMyBooks(book.getId(),book.getTitle(),book.getAuthors(),
                            book.getNumberOfPages(),book.getReadPages(),book.getYearOfPublishing(), book.getCategory());
    }

    @RequestMapping("/books/{title}")
    public List<Book> findBookByTitle(@PathVariable String title){
        return bookService.findBooksByTitle(title);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/books/{id}")
    public void updateMyBooksBookData(@PathVariable int id, @RequestBody Book book){
        bookService.updateMyBooksBookData(id,book.getTitle(),book.getAuthors(),
                                   book.getNumberOfPages(),book.getReadPages(),book.getYearOfPublishing(),book.getCategory());
    }

    //Wishlist
    @RequestMapping("/books/wishlist")
    public List<Book> getAllWishlistItems(){
        return bookService.getAllWishlistItems();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books/wishlist")
    public void addBookToWishlist(@RequestBody Book book){
        bookService.addBookToWishlist(book.getId(),book.getTitle(),book.getAuthors(),
                book.getNumberOfPages(),book.getReadPages(),book.getYearOfPublishing(), book.getPriceInUSD(), book.getCategory());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/books/wishlist/{id}")
    public void updateWishlistBookData(@PathVariable int id, @RequestBody Book book){
        bookService.updateWishlistBookData(id,book.getTitle(),book.getAuthors(),
                book.getNumberOfPages(),book.getReadPages(),book.getYearOfPublishing(), book.getPriceInUSD(),book.getCategory());
    }

}
