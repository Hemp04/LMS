package org.example;

import org.example.model.Books;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    public static final List<Books> availableBooks = new ArrayList<>();
    public static final List<Books> borrowedBooks = new ArrayList<>();

    public void addBook(Books book) throws IllegalArgumentException {
        for (Books availableBook : availableBooks) {
            if (availableBook.getISBN().equals(book.getISBN())) {
                throw new IllegalArgumentException("Book cannot be added as there is already a book added with ISBN: " + book.getISBN());
            }
        }
        availableBooks.add(book);
        System.out.println("Book with ISBN " + book.getISBN() + " added successfully!");
    }
    }

