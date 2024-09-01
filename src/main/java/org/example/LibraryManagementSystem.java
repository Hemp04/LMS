package org.example;

import org.example.model.Books;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    public static final List<Books> availableBooks = new ArrayList<>();
    public static final List<Books> borrowedBooks = new ArrayList<>();
    public void viewAvailableBooks() {
        if (availableBooks.isEmpty()) {
            System.out.println("Sorry, currently no books are available with us.");
            return;
        }
        System.out.println("Following Books are available with us: \n");
        for (Books book : availableBooks) {
            System.out.println(
                    "Title: " + book.getTitle() + "\n"
                            + "Author: " + book.getAuthor() + "\n"
                            + "PublicationYear: " + book.getPublicationYear() + "\n"
                            + "ISBN: " + book.getISBN() + "\n");
        }
    }
    public void addBook(Books book) throws IllegalArgumentException {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be null or blank.");
        }
        if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
            throw new IllegalArgumentException("Book Author cannot be null or blank.");
        }
        if (book.getISBN() == null || book.getISBN().trim().isEmpty()) {
            throw new IllegalArgumentException("Book ISBN No. cannot be null or blank.");
        }
        for (Books availableBook : availableBooks) {
            if (availableBook.getISBN().equals(book.getISBN())) {
                throw new IllegalArgumentException("Book cannot be added as there is already a book added with ISBN: " + book.getISBN());
            }
        }
        availableBooks.add(book);
        System.out.println("Book with ISBN " + book.getISBN() + " added successfully!");
    }


    }

