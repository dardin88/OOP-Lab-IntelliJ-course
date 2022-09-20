public class Main {
   public static void main(String[] args) {
      String firstInitial = args[0].substring(0,1);
      String secondInitial = args[1].substring(0,1);
      String thirdInitial = args[2].substring(0,1);

      String result = firstInitial+secondInitial+thirdInitial;
      System.out.println(result);
   }
}