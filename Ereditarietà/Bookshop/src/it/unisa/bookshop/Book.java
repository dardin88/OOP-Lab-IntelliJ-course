package it.unisa.bookshop;

import java.util.Objects;

public class Book {

    final private String title;
    final private String author;
    final private String editor;
    int numberOfCopies;

    public Book(String title, String author, String editor) {
        this.title = title;
        this.author = author;
        this.editor = editor;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getEditor() {
        return editor;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", editor='" + editor + '\'' +
                ", numberOfCopies=" + numberOfCopies +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) && author.equals(book.author) && editor.equals(book.editor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, editor);
    }
}
