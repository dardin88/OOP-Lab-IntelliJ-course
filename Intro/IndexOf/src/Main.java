public class Main {
    public static void main(String[] args) {
        String[] words = {"", "a", "sasso", "pippo", "test"};

        for (String word : words) {
            int position = -1;
            if (!word.isEmpty()) {
                char initial = word.charAt(0);
                position = word.indexOf(initial, 1);
            }
            System.out.println(position);
        }
    }
}