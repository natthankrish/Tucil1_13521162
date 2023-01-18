import java.util.Scanner;

import struct.*;

public class Main {    
    public static void main (String[] args) {
        String[] inputCards = new String[4];
        Token Deck = new Token();
        Scanner inputTray = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            inputCards[i] = inputTray.next();
        }

        Deck.constructDeck(inputCards);

        if (!Deck.isDeckValid(inputCards)) {
            System.out.println("Simbol kartu tidak sesuai. Silahkan masukkan input yang benar!");
        } else {
            System.out.println("Halo");
        }
        
        inputTray.close();
    }
}