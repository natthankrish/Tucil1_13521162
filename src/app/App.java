package app;
import java.util.Scanner;
import java.util.ArrayList;

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
                ArrayList<String> result;
                result = Deck.calculateDeck(inputCards);
                Deck.displayResult(result);
                String input = inputTray.nextLine();
                System.out.print("Do you want to save the results? (Y/N): ");
                input = inputTray.nextLine();

                if (!input.equals("Y") && !input.equals("N")) {
                    System.out.print("Wrong input! Please input (Y/N): ");
                    input = inputTray.nextLine();
                }

                if (input.equals("Y")) {
                    Deck.saveResultsToFile(inputCards, result);
                }
            }
            return true;
        } else if (choice.equals("2")){
            System.out.println("Picking Random Card..."); 
            System.out.print("Your Deck: "); 
            inputCards = Deck.randomizeDeck();
            for (int i = 0; i < 4; i++) {
                System.out.print(inputCards[i] + " ");
            }
            System.out.println();
            ArrayList<String> result;
            result = Deck.calculateDeck(inputCards);
            Deck.displayResult(result);
            System.out.print("Do you want to save the results? (Y/N): ");
            String input = inputTray.nextLine();

            if (!input.equals("Y") && !input.equals("N")) {
                System.out.print("Wrong input! Please input (Y/N): ");
                input = inputTray.nextLine();
            }

            if (input.equals("Y")) {
                Deck.saveResultsToFile(inputCards, result);
            }
            return true;
        } else { // choice = 3
            System.out.println("Thank you for using our App!");
            return false;
        }
    }
}
