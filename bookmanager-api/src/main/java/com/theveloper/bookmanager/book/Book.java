package com.theveloper.bookmanager.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

    @Id @GeneratedValue
    private int id;
    private String title;
    private String authors;
    private int numberOfPages;
    private int readPages;
    private int yearOfPublishing;
    private int priceInUSD;
    private String category;
    private boolean bought;

    public Book(int id, String title, String authors, int numberOfPages, int readPages, int yearOfPublishing, int priceInUSD, String category, boolean bought) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.readPages = readPages;
        this.yearOfPublishing = yearOfPublishing;
        this.priceInUSD = priceInUSD;
        this.category = category;
        this.bought = bought;
    }

    public Book(int id, String title, String authors, int numberOfPages, int readPages, int yearOfPublishing, String category, boolean bought) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.readPages = readPages;
        this.yearOfPublishing = yearOfPublishing;
        this.category = category;
        this.bought = bought;
    }

    public Book(String title, String authors, int numberOfPages, int readPages, int yearOfPublishing) {
        this.title = title;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.readPages = readPages;
        this.yearOfPublishing = yearOfPublishing;
    }

    public Book() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getReadPages() {
        return readPages;
    }

    public void setReadPages(int readPages) {
        this.readPages = readPages;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public int getPriceInUSD() {
        return priceInUSD;
    }

    public void setPriceInUSD(int priceInUSD) {
        this.priceInUSD = priceInUSD;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }
}
