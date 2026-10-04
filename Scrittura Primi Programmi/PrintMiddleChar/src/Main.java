public class Main {
    public static void main(String[] args) {
        String[] words = {"pippo", "pluto", "alice", "bob"};

        for (String word : words) {
            String middleChar;
            middleChar = word.substring(word.length() / 2, word.length() / 2 + 1);
            System.out.println(middleChar);
        }
    }
}