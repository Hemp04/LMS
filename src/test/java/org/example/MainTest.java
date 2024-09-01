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
        Books books = new Books("The Subtle Art of Not Giving a F*ck", "987-123-123-9811", "Mark Manson", 2016);
        // number of books before adding
        int noOfBooks = availableBooks.size();
        lms.addBook(books);
        assertEquals(noOfBooks + 1, availableBooks.size());
        assertTrue(availableBooks.contains(books));
    }

    @Test
    public void viewAvailableBooksTest() {
        lms.viewAvailableBooks();
    }

    @Test
    public void addBookWithDuplicateISBNTest() {
        Books book1 = new Books("The Four Agreements", "987-123-123-1111", "Don Miguel Ruiz", 1997);
        Books book2 = new Books("The Four Agreements", "987-123-123-1111", "Don Miguel Ruiz", 1997);

        lms.addBook(book1);
        assertThrows(IllegalArgumentException.class, () -> {
            lms.addBook(book2);
        }, "Adding a book with duplicate ISBN should thrown an IllegalArgumentException");
    }

    @Test
    public void addBookWithNullBookNameTest() {
        Books book3 = new Books(" ", "987-123-123-9200", "Mark Manson", 2015);
        assertThrows(IllegalArgumentException.class, () -> {
            lms.addBook(book3);
        }, "Adding a book with Null as a Title should thrown an IllegalArgumentException");
    }

    @Test
    public void addBookWithNullAuthorNameTest() {
        Books book4 = new Books("The Power of Habit", "987-123-123-9876", " ", 2012);
        assertThrows(IllegalArgumentException.class, () -> {
            lms.addBook(book4);
        }, "Adding a book with Null as a AuthorName should thrown an IllegalArgumentException");
    }

    @Test
    public void addBookWithNull_ISBN_Test() {
        Books book5 = new Books("Sapiens: A Brief History of Humankind", " ", "Yuval Noah Harari", 2011);
        assertThrows(IllegalArgumentException.class, () -> {
            lms.addBook(book5);
        }, "Adding a book with Null as a ISBN should thrown an IllegalArgumentException");
    }

    @Test
    public void addBookWithProperPubYearTest() {
        Books book6 = new Books("The Alchemist", "136-123-123-9875", "Paulo Coelho", 2070);
        assertThrows(IllegalArgumentException.class, () -> {
            lms.addBook(book6);
        }, "Adding a book with Wrong or Future Publication Year should thrown an IllegalArgumentException");
    }

    @Test
    public void addBookWith_Improper_ISBN_Test() {
        Books book6 = new Books("Sapiens: A Brief History of Humankind", "999", "Yuval Noah Harari", 2009);
        assertThrows(IllegalArgumentException.class, () -> {
            lms.addBook(book6);
        }, "Adding a book with Invalid ISBN No. should thrown an IllegalArgumentException");
    }

    @Test
    public void viewAvailableBooksEmptyLibrary() {
        assertThrows(IllegalArgumentException.class, () -> {
            lms.viewAvailableBooks();
        }, "Empty Library can be displayed that should thrown an IllegalArgumentException");
    }


    @Test
    public void borrowAvailableBookTest() {
        Books book = new Books("To Kill a Mockingbird", "978-006-112-0084", "Harper Lee", 1960);
        // Add a single books
        lms.addBook(book);
        // available books before borrowing
        int noOfAvailableBooks = availableBooks.size();
        // borrowed books before borrowing
        int noOfBorrowedBooks = borrowedBooks.size();
        lms.borrow_Book("987-006-112-0084");
        assertEquals(noOfAvailableBooks - 1, availableBooks.size());
        assertEquals(noOfBorrowedBooks + 1, borrowedBooks.size());
        assertTrue(borrowedBooks.contains(book));
        assertFalse(availableBooks.contains(book));
    }

    @Test
    public void borrow_Unavailable_Book_Test() {
        Books book = new Books("Power of SubConsious mind", "879-879-852-5555", "Shane Bond", 1963);
        // Add a single books
        lms.addBook(book);
        assertThrows(IllegalArgumentException.class, () -> lms.borrow_Book("654-321-321-3212"),
                "Trying to borrow an unavailable book should thrown an IllegalArgumentException");
    }

    @Test
    public void returnBorrowedBookTest() {
        Books book = new Books("To Kill a Mockingbird", "978-006-112-0084", "Harper Lee", 1960);
        // Add a single books
        lms.addBook(book);
        // borrow that book
        lms.borrow_Book("987-006-112-0084");
        // available books before returning
        int noOfAvailableBooks = availableBooks.size();
        // borrowed books before returning
        int noOfBorrowedBooks = borrowedBooks.size();
        lms.return_Book("987-123-123-0000");
        assertEquals(noOfAvailableBooks + 1, availableBooks.size());
        assertEquals(noOfBorrowedBooks - 1, borrowedBooks.size());
        assertTrue(availableBooks.contains(book));
        assertFalse(borrowedBooks.contains(book));
    }

    @Test
    public void returnWrongBookTest() {
        Books book = new Books("Art of Money", "987-123-654-7777", "Twain Hawaii", 1954);
        // Add a single books
        lms.addBook(book);
        // borrow that book
        lms.borrow_Book("987-123-654-7777");
        assertThrows(IllegalArgumentException.class, () -> lms.return_Book("879-546-123-2555"),
                "Trying to return a Wrong book as it is not yet borrowed should throw an IllegalArgumentException");
    }
}