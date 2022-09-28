import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FirstAndLastWord {

    List<String> stringList;

    public FirstAndLastWord(List<String> stringList) {
        this.stringList = stringList;
    }

    public void sort() {
        stringList.sort(new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    public void sortIgnoreCase() {
        stringList.sort(new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });
    }

    public String getFirst() {
        return stringList.get(0);
    }

    public String getLast() {
        return stringList.get(stringList.size() - 1);
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