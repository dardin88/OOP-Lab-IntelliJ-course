import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FirstAndLastWordTest {
    @Test
    public void printFirstAndLastWordTest() {
        List<String> stringList = new ArrayList<>();
        stringList.add("aaa");
        stringList.add("JJJ");
        stringList.add("zzz");

        FirstAndLastWord firstAndLastWord = new FirstAndLastWord(stringList);
        firstAndLastWord.sort();
        Assert.assertEquals("JJJ", firstAndLastWord.getFirst());
        Assert.assertEquals("zzz", firstAndLastWord.getLast());
    }

    @Test
    public void printFirstAndLastWordIgnoreCaseTest() {
        List<String> stringList = new ArrayList<>();
        stringList.add("aaa");
        stringList.add("JJJ");
        stringList.add("zzz");

        FirstAndLastWord firstAndLastWord = new FirstAndLastWord(stringList);
        firstAndLastWord.sortIgnoreCase();
        Assert.assertEquals("aaa", firstAndLastWord.getFirst());
        Assert.assertEquals("zzz", firstAndLastWord.getLast());
    }
}