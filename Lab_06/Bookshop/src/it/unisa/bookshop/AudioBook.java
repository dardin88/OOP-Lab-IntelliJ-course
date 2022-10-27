package it.unisa.bookshop;

import java.util.Objects;

public class AudioBook extends Book {

    final private int length;
    final private String format;

    public AudioBook(String title, String author, String editor, int length, String format) {
        super(title, author, editor);
        this.length = length;
        this.format = format;
    }

    public int getLength() {
        return length;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AudioBook audioBook = (AudioBook) o;
        return length == audioBook.length && format.equals(audioBook.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length, format);
    }
}
