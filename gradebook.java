import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class gradebook{
  public static void checker(String currentYear) {
    // The try statement is used to check the code and see if there are any errors when executing it.
       // An alternative would be the use of the "throws FileNotFoundException" in the decleration of the function.
    try {
      // The file object is used to store file with the grade.
         // The scanner is then used to read the file.
      File file = new File(currentYear + ".txt");
      Scanner scan = new Scanner(file);

      // While loop used to print out each individual line.
      while (scan.hasNextLine()) {
        System.out.println(scan.nextLine());
      }
    } // The catch statement is then used to print out error messadges if there are errors.
         // In this case, if the file isnt found, or any other kind of error. 
    catch (FileNotFoundException ex) {
      System.out.println("no file");
    } catch (Exception ex) {
      System.out.println("other");
    }
  }

  public static void schoolYear() {
    Scanner input = new Scanner(System.in);

    System.out.println("What school year do you wanna look at? ");
    String currentYear = input.nextLine();

    checker(currentYear);
  }

  public static void main(String[] args) {
    schoolYear();
  }
}
