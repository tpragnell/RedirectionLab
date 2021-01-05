import java.util.Scanner;
import java.util.Arrays;

public class PigLatin{
  public static String pigLatinSimple(String s){
    if(s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i'
      || s.charAt(0) == 'o' || s.charAt(0) == 'u'){
        return s + "hay";
    }

    if (s.length() == 1)
      return s + "ay";

    return s.substring(1) + s.charAt(0) + "ay";
  }

  // public static String pigLatinBest(String s){
  //
  // }

  public static String pigLatin(String s){
    if(s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i'
      || s.charAt(0) == 'o' || s.charAt(0) == 'u'){
        return s + "hay";
    }

    String[] digraphs = {"bl", "br", "ch", "ck", "cl", "cr", "dr", "fl", "fr", "gh", "gl", "gr", "ng", "ph",
    "pl", "pr", "qu", "sc", "sh", "sk", "sl", "sm", "sn", "sp", "st", "sw", "th", "tr", "tw", "wh", "wr"};
    boolean inDiagraphs = false;
    if (s.length() >= 2 && Arrays.binarySearch(digraphs, s.substring(0,2)) >= 0)
    {
      if (s.length() == 2)
        return s + "ay";
      else
        return s.substring(2) + s.substring(0,2) + "ay";
    }

    if (s.length() == 1)
      return s + "ay";

    return s.substring(1) + s.charAt(0) + "ay";
  }

  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    String line = myObj.nextLine();
    System.out.println(pigLatinSimple("mock"));
    System.out.println(pigLatinSimple("pie"));
    System.out.println(pigLatinSimple("david"));
    System.out.println(pigLatinSimple("aaron"));

    System.out.println(pigLatin("the"));
    System.out.println(pigLatin("check"));
    System.out.println(pigLatin("skee"));
    System.out.println(pigLatin("emu"));
    System.out.println(pigLatin("grade"));
  }
}
