package app;
import java.util.Scanner;

import struct.*;

public class App {
    public boolean exe (Scanner inputTray) {
        // Initialization
        String[] inputCards = new String[4];
        Deck Deck = new Deck();

        // Menu Input
        System.out.println("Choose Input");
        System.out.println("1. My Deck");
        System.out.println("2. Random Deck");
        System.out.println("3. Exit");
        System.out.print("My choice (1/2/3): ");
        String choice = inputTray.nextLine();


        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
            System.out.println("Wrong input! Please type 1/2/3.");
            System.out.print("My choice (1/2/3): ");
            choice = inputTray.nextLine();
        }
        // choice = 1/2/3

        if (choice.equals("1")) {
            for (int i = 0; i < 4; i++) {
                inputCards[i] = inputTray.next();
            }
    
            Deck.constructDeck(inputCards);
    
            if (!Deck.isDeckValid(inputCards)) {
                System.out.println("Invalid Card Deck. Please input the correct one!");
                
            } else {
                System.out.println("Halo");
            }
            return true;
        } else if (choice.equals("2")){ 
            inputCards = Deck.randomizeDeck();
            return true;
        } else { // choice = 3
            System.out.println("Thank you for using our App!");
            return false;
        }
    }
}
