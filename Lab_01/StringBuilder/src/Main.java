public class Main {
    public static void main(String[] args) {
        String sentence = "Hello, World!";
        StringBuilder newSentence = new StringBuilder();
        for (char c : sentence.toCharArray()) {
            switch (c) {
                case 'e' -> newSentence.append('o');
                case 'o' -> newSentence.append('e');
                default -> newSentence.append(c);
            }
        }

        System.out.println(newSentence);
    }
}