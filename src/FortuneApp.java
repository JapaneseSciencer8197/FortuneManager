import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main application class that handles user interaction.
 */
public class FortuneApp {

    /**
     * Displays the menu options.
     */
    public static void displayMenu() {
        System.out.println("\n----- Fortune Teller ----- ");
        System.out.println("1. Generate Random Fortune");
        System.out.println("2. Additional Fortune");
        System.out.println("3. Removing an opsion of Fortune ");
        System.out.println("4. Showing all Fortunes");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Main method to run the program.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FortuneManager manager = new FortuneManager();

        boolean running = true;

        System.out.println("Welcome to the Fortune Teller!!");
        System.out.println("Please choose the option from below 5");

        while (running) {
            displayMenu(); 

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        System.out.println("Fortune: " + manager.getRandomFortune());
                        break; // Showing the randam options 1-10

                    case 2:
                        System.out.print("Type a new fortune: ");
                        String newFortune = scanner.nextLine().trim();

                        if (newFortune.isEmpty()) {
                            throw new Exception("Error!!Please type the word at least one");
                        } // If the box was not typed anything, show "Error message"

                        manager.addFortune(newFortune);
                        System.out.println("Fortune has been added!");
                        break; 

                    case 3:
                        
                        ArrayList<String> list = manager.getAllFortunes();

                        System.out.println("\n--- All Fortunes ---");
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println(i + ": " + list.get(i));
                        }

                        System.out.print("Enter index of fortune to remove: ");
                        int index = Integer.parseInt(scanner.nextLine());

                        manager.removeFortune(index);
                        System.out.println("Fortune removed!");
                        break;

                    case 4:
                        ArrayList<String> allFortunes = manager.getAllFortunes();

                        System.out.println("\n--- All Fortunes ---");
                        for (int i = 0; i < allFortunes.size(); i++) {
                            System.out.println(i + ": " + allFortunes.get(i));
                        }
                        break;

                    case 5:
                        running = false;
                        System.out.println("Thank you for using Furtune App!! Have a nice day!!");
                        break;

                    default:
                        System.out.println("Invalid option. Please choose from 1 through 5 options.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter an appropriate number.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: Invalid index.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
