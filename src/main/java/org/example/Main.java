package org.example;

import org.example.model.Books;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.viewAvailableBooks();
        try {
            lms.addBook(new Books("Ikigai", "123-123-123-1233", "Japanese Guy", 2000));
            lms.addBook(new Books("Atomic Habits", "234-234-234-2344", "James Clear", 2018));
            lms.addBook(new Books("The Alchemist", "345-345-345-3455", "Paulo Coelho", 1988));
            lms.addBook(new Books("Sapiens: A Brief History of Humankind", "456-456-456-4566", "Yuval Noah Harari", 2011));
            lms.addBook(new Books("Thinking, Fast and Slow", "567-567-567-5677", "Daniel Kahneman", 2011));
            lms.addBook(new Books("The Power of Habit", "678-678-678-6788", "Charles Duhigg", 2012));
            lms.addBook(new Books("The Subtle Art of Not Giving a F*ck", "789-789-789-7899", "Mark Manson", 2016));
            lms.addBook(new Books("Educated", "890-890-890-8900", "Tara Westover", 2018));
            lms.addBook(new Books("The Four Agreements", "901-901-901-9011", "Don Miguel Ruiz", 1997));
            lms.addBook(new Books("The Lean Startup", "012-012-012-0122", "Eric Ries", 2011));
            lms.addBook(new Books("Rich Dad Poor Dad", "123-234-345-4567", "Robert T. Kiyosaki", 1997));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        lms.viewAvailableBooks();
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.

    }
}