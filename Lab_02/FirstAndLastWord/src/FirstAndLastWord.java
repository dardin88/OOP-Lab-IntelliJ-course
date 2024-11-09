import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstAndLastWord {

    private final List<String> stringList;

    public FirstAndLastWord(List<String> stringList) {
        this.stringList = stringList;
    }

    public void sort() {
        stringList.sort(String::compareTo);
    }

    public void sortIgnoreCase() {
        stringList.sort(String::compareToIgnoreCase);
    }

    public String getFirst() {
        return stringList.getFirst();
    }

    public String getLast() {
        return stringList.getLast();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();

        System.out.println("Dammi il numero di parole da analizzare: ");
        int numberOfWords = in.nextInt();
        in.nextLine();

        System.out.println("Dimmi se vuoi ignorare la differenza tra maiuscole e minuscole: S/N");
        String ignoreCase = in.nextLine();

        for (int i = 0; i < numberOfWords; i++) {
            System.out.println("Dammi una stringa: ");
            stringList.add(in.nextLine());
        }

        FirstAndLastWord firstAndLastWord = new FirstAndLastWord(stringList);

        switch (ignoreCase) {
            case "S" -> firstAndLastWord.sortIgnoreCase();
            case "N" -> firstAndLastWord.sort();
        }

        System.out.println("The first word is " + firstAndLastWord.getFirst());
        System.out.println("The last word is " + firstAndLastWord.getLast());
    }
}