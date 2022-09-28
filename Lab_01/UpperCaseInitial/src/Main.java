public class Main {
    public static void main(String[] args) {
        String[] words = {"", "a", "alice", "bob", "pippo", "pluto"};

        for (String word : words) {
            if (!word.isEmpty()) {
                String initial = String.valueOf(word.charAt(0));
                String upperCaseInitial = initial.toUpperCase();
                String remainingLetters = word.substring(1);
                String upperCaseWord = upperCaseInitial + remainingLetters;
                System.out.println(upperCaseWord);
            } else {
                System.out.println();
            }
        }
    }
}