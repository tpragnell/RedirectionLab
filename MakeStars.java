import java.util.Scanner;

public class MakeStars{

  public static void main(String[] args) {

    Scanner myObj = new Scanner(System.in);

    while(myObj.hasNextLine()){
        String line = myObj.nextLine();
        //System.out.println(line);
        boolean space = true;
        for(int i=0; i<line.length(); i++){
          if(Character.isLetter(line.charAt(i))){
            System.out.print("*");
            space = false;
          } else if(!space) {
            System.out.print(" ");
            space = true;
          }
        }
        System.out.println();
    }


  }

}
