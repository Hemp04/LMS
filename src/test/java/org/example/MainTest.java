package org.example;


import org.example.model.Books;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    LibraryManagementSystem lms;
    public static final List<Books> availableBooks = LibraryManagementSystem.availableBooks;
    public static final List<Books> borrowedBooks = LibraryManagementSystem.borrowedBooks;

    @BeforeEach
    public void setUp() {
        lms = new LibraryManagementSystem();
    }

    @Test
    public void addBookTest() {
        Books books = new Books("title", "987-123-123-9876", "author", 2004);
        // number of books before adding
        int noOfBooks = availableBooks.size();
        lms.addBook(books);
    }
    @Test
    public void viewAvailableBooksTest(){
        lms.viewAvailableBooks();

    }

}