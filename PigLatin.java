import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;

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

  public static String pigLatin(String s){
    if(s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i'
      || s.charAt(0) == 'o' || s.charAt(0) == 'u'){
        return s + "hay";
    }

    String[] digraphs = {"bl", "br", "ch", "ck", "cl", "cr", "dr", "fl", "fr", "gh", "gl", "gr", "ng", "ph",
    "pl", "pr", "qu", "sc", "sh", "sk", "sl", "sm", "sn", "sp", "st", "sw", "th", "tr", "tw", "wh", "wr"};
    boolean inDigraphs = false;
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

  public static String pigLatinBest(String s){
    boolean punctuationEnd = false;
    boolean vowelStart = false;
    boolean inDigraphs = false;

    String[] digraphs = {"bl", "br", "ch", "ck", "cl", "cr", "dr", "fl", "fr", "gh", "gl", "gr", "ng", "ph",
    "pl", "pr", "qu", "sc", "sh", "sk", "sl", "sm", "sn", "sp", "st", "sw", "th", "tr", "tw", "wh", "wr"};

    if (s.length() == 1)
      return s + "ay";

    if(!Character.isLetter(s.charAt(0))){
      return s;
    }

    if(!Character.isLetterOrDigit(s.charAt(s.length()-1))){
      punctuationEnd = true;
    }

    if(s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i'
      || s.charAt(0) == 'o' || s.charAt(0) == 'u'){
        vowelStart = true;
    }

    if (s.length() >= 2 && Arrays.binarySearch(digraphs, s.substring(0,2)) >= 0){
      inDigraphs = true;
    }

    if(vowelStart && !punctuationEnd && !inDigraphs){
      return s + "hay";
    } else if(vowelStart && punctuationEnd && !inDigraphs){
      return s.substring(0,s.length()-1) + "hay" + s.charAt(s.length()-1);
    } else if(!vowelStart && punctuationEnd && !inDigraphs){
      return s.substring(1,s.length()-1) + s.charAt(0) + "ay" + s.charAt(s.length()-1);
    }

    if(inDigraphs)
    {
      if (s.length() == 2 && !punctuationEnd){
        return s + "ay";
      } else if((s.length() == 2 && punctuationEnd)){
        return s.substring(0,2) + "ay" + s.charAt(s.length()-1);
      } else if(!punctuationEnd){
        return s.substring(2) + s.substring(0,2) + "ay";
      } else
      return s.substring(2,s.length()-1) + s.substring(0,2) + "ay" + s.charAt(s.length()-1);
    }

    return s.substring(1) + s.charAt(0) + "ay";
  }

  public static void main(String[] args) {

    System.out.println(pigLatinSimple("mock"));
    System.out.println(pigLatinSimple("pie"));
    System.out.println(pigLatinSimple("david"));
    System.out.println(pigLatinSimple("aaron"));

    System.out.println(pigLatin("the"));
    System.out.println(pigLatin("check"));
    System.out.println(pigLatin("skee"));
    System.out.println(pigLatin("emu"));
    System.out.println(pigLatin("grade"));

    System.out.println(pigLatinBest("*emu"));
    System.out.println(pigLatinBest("4chan"));
    System.out.println(pigLatinBest("fish!"));
    System.out.println(pigLatinBest("fish"));
    System.out.println(pigLatinBest("the."));
    System.out.println(pigLatinBest("cat!"));
    System.out.println(pigLatinBest("amazing?"));
    System.out.println(pigLatinBest("apple%"));

    Scanner myObj = new Scanner(System.in);
    while(myObj.hasNextLine()){
        String line = myObj.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        while (st.hasMoreTokens()) {
        System.out.print(pigLatinBest(st.nextToken().toLowerCase()) + " ");
        }
        System.out.println();
      }
  }
}
