import java.util.ArrayList;
import java.util.Random;


/**
 * Fortune Teller Console Application
 * 
 * Description: This program allows users to generate random fortunes,
 * add new fortunes, remove existing ones, and display all fortunes
 * using a console-based interface. Logic is separated from user interaction.
 * 
 * Name: Yushi Kawashima
 * Date: 5/15/2026
 */

public class FortuneManager {

    private ArrayList<String> fortunes;
    private Random random;

    public FortuneManager() {

        fortunes = new ArrayList<>();
        random = new Random();

        // Default types of Fortunes
        fortunes.add("You will have a great day!");
        fortunes.add("Success is coming your way.");
        fortunes.add("Be patient, good things take time.");
        fortunes.add("An eciting oppotunity awaits you.");
        fortunes.add("Happiness begins with you.");
        fortunes.add("A pleasant suprise is in store.");
        fortunes.add("Hard work will pay off soon.");
        fortunes.add("Except good news in the near future.");
        fortunes.add("You will achieve your goals.");
        fortunes.add("Adventure is around the corner.")
    }

    // Random choice of Fortune

    public String getRandomFortune() {

        if (fortunes.isEmpty()) {
            return "Empty fortune.";
        }

        int index = random.nextInt(fortunes.size());

        return fortunes.get(index);
    }

    // Show all options

    public String getAllFortunes() {

        if (fortunes.isEmpty()) {
            return "Empty fortune.";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < fortunes.size(); i++) {

            sb.append(i)
              .append(": ")
              .append(fortunes.get(i))
              .append("\n");
        }

        return sb.toString();
    }

    // Add option of Fortune

    public void addFortune(String text) {

        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException(
                    "Please write the sentence.");}

        fortunes.add(text);
    }

    // Remove the option from Options 
    public void removeFortune(String text) {

        if (index < 0 || index >= fortunes.size()) {
            throw new IndexOutOfBoundsException( "Please choose the valuable number.");
        }

        fortunes.remove(index);
    }

    
}
