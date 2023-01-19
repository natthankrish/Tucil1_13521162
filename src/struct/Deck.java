package struct;

import java.util.Random;

public class Deck {
    final String[] allowedChar = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};
    final String[] operator = {"+", "-", "*", "/", "(", ")"};
    String[] cardDeck;

    public void constructDeck (String[] inputCards) {
        // Melakukan Inisialisasi Deck
        this.cardDeck = new String[inputCards.length];
        for (int i = 0; i < inputCards.length; i++) {
            this.cardDeck[i] = inputCards[i];
        }
    }

    public boolean isDeckValid (String[] cardIn) {
        // Melakukan check apakah input merupakan ranks dari kartu. 
        boolean valid = true;
        int i = 0;
        while (i < cardIn.length && valid) {
            int j = 0;
            boolean found = false;
            while (j < allowedChar.length && !found) {
                // System.out.println(cardIn[i] + " " + allowedChar[j]);
                if (allowedChar[j].equals(cardIn[i])) {
                    found = true;
                }
                j++;
            }
            valid = found;
            i++;
        }
        return valid;
    }

    public String[] randomizeDeck () {
        Random rand = new Random();
        String[] randomDeck = new String[4];

        for (int i = 0; i < 4; i++) {
            randomDeck[i] = allowedChar[rand.nextInt(13)];
            System.out.println(randomDeck[i]);
        }
        return randomDeck;
    }
    // public static void main (String[] args) {
    //     Token a = new Token();
    //     System.out.println(a.checkInput("1"));
    // }
}
