package org.example;

import org.example.model.Books;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        LibraryManagementSystem lms = new LibraryManagementSystem();
//        lms.viewAvailableBooks();
        try {
            lms.addBook(new Books("Atomic Habits", "978-073-521-1292", "James Clear", 2018));
            lms.addBook(new Books("Sapiens: A Brief History of Humankind", "978-006-231-6097", "Yuval Noah Harari", 2014));
            lms.addBook(new Books("The Alchemist", "978-006-231-5007", "Paulo Coelho", 1988));
            lms.addBook(new Books("To Kill a Mockingbird", "978-006-112-0084", "Harper Lee", 1960));
            lms.addBook(new Books("1984", "978-045-152-4935", "George Orwell", 1949));
            lms.addBook(new Books("Becoming", "978-152-476-3138", "Michelle Obama", 2018));
            lms.addBook(new Books("Rich Dad Poor Dad", "123-234-345-4567", "Robert T. Kiyosaki", 1997));
            lms.addBook(new Books("Educated", "978-039-959-0504", "Tara Westover", 2018));
            lms.addBook(new Books("The Catcher in the Rye", "978-031-676-9488", "J.D. Salinger", 1951));
            lms.addBook(new Books("The Great Gatsby", "978-074-327-3565", "F. Scott Fitzgerald", 1925));
            lms.addBook(new Books("The Power of Now: A Guide to Spiritual Enlightenment", "978-157-731-4806", "Eckhart Tolle", 1997));


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        lms.viewAvailableBooks();
        try {
            lms.borrow_Book("978-157-731-4806");
            lms.borrow_Book("123-234-345-4567");
            lms.return_Book("978-157-731-4806");
            lms.return_Book("123-234-345-4567");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}