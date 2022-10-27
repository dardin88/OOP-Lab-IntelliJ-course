package it.unisa.bookshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Bookshop {

    final private List<Book> bookshop;

    public Bookshop() {
        bookshop = new ArrayList<>();
    }

    public List<Book> findByAuthor(String author) {
        List<Book> resultList = new ArrayList<>();
        for (Book b : this.bookshop) {
            if (b.getAuthor().equals(author)) {
                resultList.add(b);
            }
        }
        return resultList;
    }

    public List<Book> findByTitleContent(String titleContent) {
        List<Book> resultList = new ArrayList<>();
        for (Book b : this.bookshop) {
            if (b.getTitle().toLowerCase().contains(titleContent.toLowerCase())) {
                resultList.add(b);
            }
        }
        return resultList;
    }

    public List<Book> findMaxAvailable() {
        List<Book> resultList = new ArrayList<>();
        this.bookshop.sort(Collections.reverseOrder(new Comparator<>() {
            @Override
            public int compare(Book book, Book t1) {
                return Integer.compare(book.numberOfCopies, t1.numberOfCopies);
            }
        }));
        int maxAvailableCopiesPerBook = this.bookshop.get(0).numberOfCopies;

        for (Book b : this.bookshop) {
            if (b.getNumberOfCopies() == maxAvailableCopiesPerBook) {
                resultList.add(b);
            }
        }
        return resultList;
    }

    public List<Book> findBelowAvailability(int threshold) {
        List<Book> resultList = new ArrayList<>();
        for (Book b : this.bookshop) {
            if (b.getNumberOfCopies() < threshold) {
                resultList.add(b);
            }
        }
        return resultList;
    }

    public List<Book> getBookshop() {
        return bookshop;
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String type = input.nextLine();
            String title = input.nextLine();
            String author = input.nextLine();
            String editor = input.nextLine();
            int numberOfCopies = Integer.parseInt(input.nextLine());
            if (type.equals("AudioBook")) {
                int length = Integer.parseInt(input.nextLine());
                String format = input.nextLine();
                AudioBook bookToAdd = new AudioBook(title, author, editor, length, format);
                bookToAdd.setNumberOfCopies(numberOfCopies);
                this.bookshop.add(bookToAdd);
            } else {
                Book bookToAdd = new Book(title, author, editor);
                bookToAdd.setNumberOfCopies(numberOfCopies);
                this.bookshop.add(bookToAdd);
            }
        }
    }
}
