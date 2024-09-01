package org.example;


import org.example.model.Books;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    LibraryManagementSystem lms;
    public static final List<Books> availableBooks = LibraryManagementSystem.get_Available_Books();
    public static final List<Books> borrowedBooks = LibraryManagementSystem.get_Borrowed_Books();

    @BeforeEach
    public void setUp() {
        lms = new LibraryManagementSystem();
    }

    @Test
    public void addBookTest() {
        Books books = new Books("title", "987-123-123-9870", "author", 2004);
        // number of books before adding
        int noOfBooks = availableBooks.size();
        lms.addBook(books);
        assertEquals(noOfBooks + 1, availableBooks.size());
        assertTrue(availableBooks.contains(books));
    }
    @Test
    public void viewAvailableBooksTest(){
        lms.viewAvailableBooks();
    }
    @Test
    public void addBookWithDuplicateISBNTest(){
        Books book1 = new Books("title", "987-123-123-9887", "author", 2004);
        Books book2 = new Books("title", "987-123-123-9887", "author", 2004);

        lms.addBook(book1);
        assertThrows(IllegalArgumentException.class, () -> {
            lms.addBook(book2);
        }, "Adding a book with duplicate ISBN should thrown an IllegalArgumentException");
    }

    @Test
    public void addBookWithNullBookNameTest(){
        Books book3 = new Books(" ", "987-123-123-9875", "author", 2004);
        assertThrows(IllegalArgumentException.class, () -> {
            lms.addBook(book3);
        }, "Adding a book with Null as a Title should thrown an IllegalArgumentException");
    }

    @Test
    public void addBookWithNullAuthorNameTest(){
        Books book4 = new Books("title", "987-123-123-9873", " ", 2004);
        assertThrows(IllegalArgumentException.class, () -> {
            lms.addBook(book4);
        }, "Adding a book with Null as a AuthorName should thrown an IllegalArgumentException");
    }

    @Test
    public void addBookWithNull_ISBN_Test(){
        Books book5 = new Books("title", " ", "author", 2014);
        assertThrows(IllegalArgumentException.class, () -> {
            lms.addBook(book5);
        }, "Adding a book with Null as a ISBN should thrown an IllegalArgumentException");
    }

    @Test
    public void addBookWithProperPubYearTest(){
        Books book6 = new Books("title", "987-123-123-9879", "author", 2044);
        assertThrows(IllegalArgumentException.class, () -> {
            lms.addBook(book6);
        }, "Adding a book with Wrong or Future Publication Year should thrown an IllegalArgumentException");
    }

    @Test
    public void addBookWith_Improper_ISBN_Test(){
        Books book6 = new Books("title", "987-123-123-98798752", "author", 2014);
        assertThrows(IllegalArgumentException.class, () -> {
            lms.addBook(book6);
        }, "Adding a book with Invalid ISBN No. should thrown an IllegalArgumentException");
    }
    @Test
    public void viewAvailableBooksEmptyLibrary(){
        assertThrows(IllegalArgumentException.class, () -> {
            lms.viewAvailableBooks();
        }, "Empty Library can be displayed that should thrown an IllegalArgumentException");
    }


    @Test
    public void borrowAvailableBookTest() {
        Books book = new Books("title", "987-123-123-9876", "author", 2004);
        // Add a single books
        lms.addBook(book);
        // available books before borrowing
        int noOfAvailableBooks = availableBooks.size();
        // borrowed books before borrowing
        int noOfBorrowedBooks = borrowedBooks.size();
        lms.borrowBook("987-123-123-9876");
        assertEquals(noOfAvailableBooks - 1, availableBooks.size());
        assertEquals(noOfBorrowedBooks + 1, borrowedBooks.size());
        assertTrue(borrowedBooks.contains(book));
        assertFalse(availableBooks.contains(book));
    }
}