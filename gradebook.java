import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

class gradebook{
  // The function is used to create a new file from the start of the program.
  public static void newFileMaker() {
    Scanner input = new Scanner(System.in);
    System.out.println("Write the name of the new file: ");

    String newFileName = input.nextLine();

    // The try statement is used to execute the code, and the catch statement is used if / when an error occurs.
    try {
      if (newFileName.equals("exit")) {
        System.exit(0);
      } else {
        File newFile = new File(newFileName + ".txt");

        // If statement used to check if the file that the user wants to create exists or not.
           // If it doesn't, then the if block is executed.
        if (newFile.createNewFile()) {
          System.out.println("New file created.\nDo you want to write to the file now? ");
          String newInput = input.nextLine();

          if (newInput.equals("yes")) {
            System.out.println("Write out the most recent grades with their respective classes.");

            FileWriter newGrades = new FileWriter(newFileName + ".txt");

            String userNewGrades = input.nextLine();
            newGrades.write(userNewGrades);
            newGrades.close();
          }
        } else {
          System.out.println("File already exists");
          newFileMaker();
        }
      }
    } catch (IOException ex) {
      System.out.println("An error occured.");
    }
  }

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
      System.out.println("No file found.\nDo you want to create a new file for this new school year? ");
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
    String[] options = {"1) Check the grades from a school year.",
                        "2) Write a new gradebook for a new school year",
                        "3) Exit the program.",
                        "\nSelect 1-3"};

    for (int i = 0; i < options.length; i++) {
      System.out.println(options[i]);
    }

    Scanner input = new Scanner(System.in);
    String choice = input.nextLine();

    if (choice.equals("1")) {
      System.out.println("What file do you want to look at?");
      String currentYear = input.nextLine();

      checker(currentYear);
    } else if (choice.equals("2")) {
      newFileMaker();
    } else if (choice.equals("3")) {
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    schoolYear();
  }
}
