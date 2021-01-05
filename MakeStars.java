import java.util.Scanner;

public class MakeStars{

  public static void main(String[] args) {

    Scanner myObj = new Scanner(System.in);

    while(myObj.hasNextLine()){
        String line = myObj.nextLine();
        //System.out.println(line);
        for(int i=0; i<line.length(); i++){
          if(Character.isLetter(line.charAt(i))){
            System.out.print("*");
          } else {
            System.out.print(" ");
          }
        }
        System.out.println();
    }


  }

}
