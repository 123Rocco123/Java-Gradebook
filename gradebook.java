import java.util.Scanner;
import java.io.File;

class gradebook{
  public static void checker(String currentYear) {
    File testObject = new File(currentYear + ".txt");

    if ((testObject).exists()) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }

  public static void schoolYear() {
    Scanner input = new Scanner(System.in);

    System.out.println("What school year are you in? ");
    String currentYear = input.nextLine();

    checker(currentYear);
  }

  public static void main(String[] args) {
    schoolYear();
  }
}
