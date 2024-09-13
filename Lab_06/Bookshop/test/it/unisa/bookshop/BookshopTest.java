package it.unisa.bookshop;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;

public class BookshopTest {

    @Test
    public void readLibraryTest() {
        Bookshop library = new Bookshop();
        File file = Path.of("test/").resolve("testData.txt").toFile();
        try {
            library.readUserDataFromFile(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(7, library.getBookshop().size());
    }

    @Test
    public void findByAuthorTest() {
        Bookshop library = new Bookshop();
        File file = Path.of("test/").resolve("testData.txt").toFile();
        try {
            library.readUserDataFromFile(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Book> books = library.findByAuthor("Camilleri Andrea");
        Assert.assertEquals(1, books.size());
        Assert.assertEquals("Una voce di notte", books.getFirst().getTitle());
    }

    @Test
    public void findByTitleContentTest() {
        Bookshop library = new Bookshop();
        File file = Path.of("test/").resolve("testData.txt").toFile();
        try {
            library.readUserDataFromFile(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Book> books = library.findByTitleContent("Sogni");
        Assert.assertEquals("Mo Yan", books.getFirst().getAuthor());
    }

    @Test
    public void findMaxAvailabilityTest() {
        Bookshop library = new Bookshop();
        File file = Path.of("test/").resolve("testData.txt").toFile();
        try {
            library.readUserDataFromFile(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Book> books = library.findMaxAvailable();
        Assert.assertEquals("Il corpo umano", books.getFirst().getTitle());
        Assert.assertEquals("Giordano Paolo", books.getFirst().getAuthor());
        Assert.assertEquals("Mondadori", books.getFirst().getEditor());
    }

    @Test
    public void findBelowAvailabilityTest() {
        Bookshop library = new Bookshop();
        File file = Path.of("test/").resolve("testData.txt").toFile();
        try {
            library.readUserDataFromFile(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Book> books = library.findBelowAvailability(15);
        Assert.assertEquals(2, books.size());
    }

}