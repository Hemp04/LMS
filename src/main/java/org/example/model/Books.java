package org.example.model;

public class Books {

    String title;
    String ISBN;
    String author;
    int publicationYear;

    public Books(String title, String ISBN, String author, int publicationYear) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return this.title;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
