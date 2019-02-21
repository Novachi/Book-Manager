package com.theveloper.bookmanager.book;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, String> {
    @Query(value = "SELECT id,title,authors,numberOfPages,readPages,yearOfPublishing FROM Book WHERE title LIKE %?1%")
    List<Book> findAllByTitle(String title);

    List<Book> findAllByBought(boolean bought);
}
