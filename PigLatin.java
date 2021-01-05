import java.util.Scanner;

public class PigLatin{
  public static String pigLatinSimple(String s){
    boolean vowel = false;
    if(s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i'
      || s.charAt(0) == 'o' || s.charAt(0) == 'u'){
        vowel = true;
    }
    if(vowel){
      return s + "hay";
    }
    return s.substring(1) + s.charAt(0) + "ay";
  }

  // public static String pigLatin(String s){
  //
  // }

  // public static String pigLatinBest(String s){
  //
  // }

  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    String line = myObj.nextLine();
    System.out.println(pigLatinSimple("mock"));
    System.out.println(pigLatinSimple("pie"));
    System.out.println(pigLatinSimple("david"));
    System.out.println(pigLatinSimple("aaron"));
  }
}
