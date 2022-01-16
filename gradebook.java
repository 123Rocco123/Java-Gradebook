import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

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
      Scanner input = new Scanner(System.in);
      System.out.println("no file\nDo you want to create a new file for this new school year? ");
      String newFile = input.nextLine();

      if (newFile.equals("yes")) {
        try {
          System.out.print("New file name: ");
          String newFileName = input.nextLine();

          File newFileCreate = new File(newFileName + ".txt");

          if (newFileCreate.createNewFile()) {
            System.out.println("File Created: " + newFileCreate.getName());
            System.out.println("Do you want to write to the file? ");
            String writeToFile = input.nextLine();

            if (writeToFile.equals("yes")) {
              try {
                FileWriter writerObject = new FileWriter(newFileName + ".txt");

                System.out.println("What do you want to write? ");

                String textToWrite = input.nextLine();
                writerObject.write(textToWrite + ".txt");
                writerObject.close();
              } catch (IOException e) {
                System.out.println("Error Occured");
              }
            } else {
              System.exit(0);
            }
          } else {
            System.out.println("File already exists");
            System.exit(0);
          }
        } catch (IOException e) {
          System.out.println("Error occured.");
        }
      }
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
