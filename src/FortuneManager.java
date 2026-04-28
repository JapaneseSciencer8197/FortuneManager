/**
 * Fortune Teller Console Application
 * 
 * Description: This program allows users to generate random fortunes,
 * add new fortunes, remove existing ones, and display all fortunes
 * using a console-based interface. Logic is separated from user interaction.
 * 
 * Name: Yushi Kawashima
 * Date: 4/4/2026
 */

import java.util.ArrayList;
import java.util.Random; 

/**
 * Handles all logic related to fortune storage and manipulation.
 */
class FortuneManager {

    private ArrayList<String> fortunes; 

    /**
     * Constructor initializes the list with default fortunes.
     */
    public FortuneManager() {
        fortunes = new ArrayList<>();

        fortunes.add("Today, you can display a best performance.");
        fortunes.add("You can get a grate experience today.");
        fortunes.add("Variable oppotunity is approaching");
        fortunes.add("You can spend this day as good as your imagine.");
        fortunes.add(" Do not waise your chance.");
        fortunes.add("You have to choose the human relationship.");
        fortunes.add("Believe in yourself, and believe in yourself and dreams will cometrue.");
        fortunes.add("Today, you might cannot display a good performance as good as your imagine.");
        fortunes.add("Today should be a day that avoiding the waste human relashonship.");
        fortunes.add("Use causion, each of your unreasnable behavior makes you crash.");
    }

    /**
     * Returns a random fortune.
     * 
     * @return a random fortune string
     */
    public String getRandomFortune() {
        Random rand = new Random();
        int index = rand.nextInt(fortunes.size());
        return fortunes.get(index);
    }

    /**
     * Adds a new fortune to the list.
     * 
     * @param fortune the fortune to add
     */
    public void addFortune(String fortune) {
        fortunes.add(fortune);
    }

    /**
     * Removes a fortune at a given index.
     * 
     * @param index the index of the fortune to remove
     */
    public void removeFortune(int index) {
        fortunes.remove(index);
    }

    /**
     * Returns all fortunes.
     * 
     * @return ArrayList of fortunes
     */
    public ArrayList<String> getAllFortunes() {
        return fortunes;
    }
}

