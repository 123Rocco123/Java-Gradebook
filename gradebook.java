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
          System.out.println("New file created.\nDo you want to write to the file now (yes/no)? ");
          String newInput = input.nextLine();

          if (newInput.equals("yes")) {
            System.out.println("Write out the most recent grades with their respective classes.");

            FileWriter newGrades = new FileWriter(newFileName + ".txt");

            String userNewGrades = input.nextLine();
            newGrades.write(userNewGrades);
            newGrades.close();

            schoolYear();
          } else {
            schoolYear();
          }
        } else {
          System.out.println("File already exists");
          schoolYear();
        }
      }
    } catch (IOException ex) {
      System.out.println("An error occured.");
      schoolYear();
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
      System.out.println("No file found.\nDo you want to create a new file for this new school year (yes/no)? ");
      String newFile = input.nextLine();

      if (newFile.equals("yes")) {
        System.out.println("");
        newFileMaker();
      } else {
        System.out.println("");
        schoolYear();
      }
    } catch (Exception ex) {
      System.out.println("Other error occured.");
      schoolYear();
    }
  }

  public static void schoolYear() {
    String[] options = {"1) Check the grades from a school year.",
                        "2) Write a new gradebook for a new school year.",
                        "3) Check the current text files in the folder.",
                        "4) Exit the program.",
                        "\nSelect 1-4"};

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
      // Used to create an object of the files in the working directory.
      File fileFinder = new File(".");

      // String array containing the names of the files in the working directory.
      String[] fileList = fileFinder.list();

      // The for each look and if statement are used to print out the text files in the working directory.
      System.out.println("\nCurrent Files in Working Directory:\n");
      for (String str : fileList) {
        if (str.indexOf(".txt") >= 0) {
          System.out.println(str);
        }
      }
    } else if (choice.equals("4")) {
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    schoolYear();
  }
}
