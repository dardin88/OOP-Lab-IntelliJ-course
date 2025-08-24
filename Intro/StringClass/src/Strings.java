public class Strings {
    public static void main(String[] args) {
        String vuota = "";        // stringa con valore nullo
        String nome = "Luigi";    // stringa con valore Luigi

        System.out.println(vuota.length());
        System.out.println(nome.length());
        System.out.println("buongiorno".length());

        String s1 = "barba", s2 = "gianni";
        System.out.println(s1.concat(s2));

        System.out.println(s1 + s2); // stampa "barbagianni"
        System.out.println("la " + s1 + " di " + s2);

        String hamburger = "hamburger";
        String short_hamburger = hamburger.substring(3);
        String shorter_hamburger = hamburger.substring(3, 7);
        String uppercase_hamburger = hamburger.toUpperCase();
        String my_hamburger = hamburger.concat(" with chips");

        System.out.println(hamburger);
        System.out.println(shorter_hamburger);
        System.out.println(short_hamburger);
        System.out.println(uppercase_hamburger);
        System.out.println(my_hamburger);
    }
}