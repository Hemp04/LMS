package org.example;

import org.example.model.Books;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LibraryManagementSystem {
    private static final List<Books> availableBooks = new ArrayList<>();
    private static final List<Books> borrowedBooks = new ArrayList<>();

    public static List<Books> get_Available_Books() {
        return Collections.unmodifiableList(availableBooks);
    }
    public static List<Books> get_Borrowed_Books() {
        return Collections.unmodifiableList(borrowedBooks);
    }

    public void viewAvailableBooks() {
        if (availableBooks.isEmpty()) {

            System.out.println("Sorry, currently no books are available with us.");
            throw new IllegalArgumentException("Sorry, currently no books are available with us.");
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
        if (book.getPublicationYear() >= LocalDate.now().getYear() || book.getPublicationYear() <= 1800) {
            throw new IllegalArgumentException("The year " + book.getPublicationYear() + " is out of the range of  1800 to "+LocalDate.now().getYear()+".");
        }
        if (book.getISBN().length() != 16 ) {
            throw new IllegalArgumentException("Book ISBN No. Invalid ");
        }
        for (Books availableBook : availableBooks) {
            if (availableBook.getISBN().equals(book.getISBN())) {
                throw new IllegalArgumentException("Book cannot be added as there is already a book added with ISBN: " + book.getISBN());
            }
        }
        availableBooks.add(book);
        System.out.println("Book with ISBN " + book.getISBN() + " added successfully!");
    }
    public void borrowBook(String ISBN){
        // Using Iterator to safely and efficiently remove the book from the list while iterating it at the same time
        Iterator<Books> iterator = availableBooks.iterator();
        while (iterator.hasNext()) {
            Books book = iterator.next();
            if (book.getISBN().equals(ISBN)) {
                iterator.remove();
                borrowedBooks.add(book);
                System.out.println("Book with ISBN " + ISBN + " borrowed Successfully!");
                return;
            }
        }
    }

    }

