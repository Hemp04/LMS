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
    }

