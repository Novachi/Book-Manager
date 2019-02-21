package com.theveloper.bookmanager.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    //Everything related to MyBooks list
    public List<Book> getAllMyBooks() {
        return bookRepository.findAllByBought(true);
    }

    public List<Book> findBooksByTitle(String title){
        return bookRepository.findAllByTitle(title);
    }

    public void addBookToMyBooks(int id, String title, String authors, int numberOfPages, int readPages, int yearOfPublishing,String category){
        bookRepository.save(new Book(id,title,authors,numberOfPages,readPages,yearOfPublishing,category,true));
    }

    //This one can be used in each case since it searches by ID
    public void deleteBook(int bookId){
        bookRepository.delete(new Book(bookId,"","",0,0,0,"",false));
    }

    public void updateMyBooksBookData(int id, String title, String authors, int numberOfPages, int readPages, int yearOfPublishing,String category){
        bookRepository.save(new Book(id,title,authors,numberOfPages,readPages,yearOfPublishing, category,true));
    }


    //Everything related to Wishlist
    public List<Book> getAllWishlistItems(){
        return bookRepository.findAllByBought(false);
    }

    public void addBookToWishlist(int id, String title, String authors, int numberOfPages, int readPages, int yearOfPublishing, int price,String category){
        bookRepository.save(new Book(id,title,authors,numberOfPages,readPages,yearOfPublishing,price,category,false));
    }

    public void updateWishlistBookData(int id, String title, String authors, int numberOfPages, int readPages, int yearOfPublishing, int price,String category){
        bookRepository.save(new Book(id,title,authors,numberOfPages,readPages,yearOfPublishing, price, category,false));
    }

}
